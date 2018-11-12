package org.mmonahan.mgame.chess.piece;

import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.Set;

public class Queen extends ChessPiece {

    private Rook rook;
    private Bishop bishop;

    /**
     * A queen moves like a bishop and a rook, so just delegate.
     */
    public Queen(String id, Player owner) {
        super(id, owner);
        rook = new Rook(id, owner);
        bishop = new Bishop(id, owner);
    }

    @Override
    public Set<Position> getToPositions(Board board, Position from) {
        Set<Position> queenPositions = rook.getToPositions(board, from);
        queenPositions.addAll(bishop.getToPositions(board, from));
        return queenPositions;
    }
}
