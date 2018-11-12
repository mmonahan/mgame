package org.mmonahan.mgame.lib;

import java.util.HashMap;
import java.util.Map;

public class Board {

    public static final Position REMOVE_FROM_BOARD = new Position(-1,-1);

    private Map<Position, Piece> boardPositions;
    private int maxX;
    private int maxY;

    public Board(int tall, int wide) {
        this.maxY = tall;
        this.maxX = wide;
        boardPositions = new HashMap<>();
    }

    public void placePiece(Piece piece, Position startPosition) {
        if (!isOnBoard(startPosition)) {
            throw new RuntimeException("Invalid placement: " + piece.getID() + " " + startPosition);
        }
        boardPositions.put(startPosition, piece);
    }

    public Move makeMove(Player player, Position fromPosition, Position toPosition) {

        //check if moves are on board
        if (!isOnBoard(fromPosition)) {
            return new Move("Invalid board position: " + fromPosition);
        }
        if (!isOnBoard(toPosition)) {
            return new Move("Invalid board position: " + toPosition);
        }

        //check if piece can make move
        Piece movingPiece = boardPositions.get(fromPosition);
        if (null == movingPiece) {
            return new Move("No piece at position: " + fromPosition);
        }
        Move newMove = movingPiece.makeMove(player, this, fromPosition, toPosition);

        //update board with move results
        for (Move.Result result: newMove.getResults()) {
            boardPositions.remove(result.getFromPosition(), result.getFromPiece());
            if (!result.getToPosition().equals(REMOVE_FROM_BOARD)) {
                boardPositions.put(result.getToPosition(), result.getToPiece());
            }
        }

        return newMove;
    }

    public Piece getPieceAt(Position position) {
        return boardPositions.get(position);
    }

    public boolean isOnBoard(Position position) {
        return position.getX() > 0 &&
                position.getX() <= maxX &&
                position.getY() > 0 &&
                position.getY() <= maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
