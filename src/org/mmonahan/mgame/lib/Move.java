package org.mmonahan.mgame.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * The result of a move in this game. There may be multiple pieces moved as the result of a single move,
 * or there may be no pieces moved if the move was invalid.
 */
public class Move {
    private String description;
    private List<Result> results = new ArrayList<>();

    public Move(String description) {
        this.description = description;
    }

    public boolean isValid() {
        return results.size() != 0;
    }

    public void addResult(Piece piece, Position fromPosition, Position toPosition) {
        results.add(new Result(piece, piece, fromPosition, toPosition));
    }

    public void addResult(Piece fromPiece, Piece toPiece, Position fromPosition, Position toPosition) {
        results.add(new Result(fromPiece, toPiece, fromPosition, toPosition));
    }

    public List<Result> getResults() {
        return results;
    }

    public String getDescription() {
        return description;
    }

    /**
     * The resulting position of a piece after a move.
     */
    public class Result {
        private Piece fromPiece;
        private Piece toPiece;
        private Position fromPosition;
        private Position toPosition;

        public Result(Piece fromPiece, Piece toPiece, Position fromPosition, Position toPosition) {
            this.fromPiece = fromPiece;
            this.toPiece = toPiece;
            this.fromPosition = fromPosition;
            this.toPosition = toPosition;
        }

        public Piece getFromPiece() {
            return fromPiece;
        }

        public Piece getToPiece() {
            return toPiece;
        }

        public Position getFromPosition() {
            return fromPosition;
        }

        public Position getToPosition() {
            return toPosition;
        }
    }
}
