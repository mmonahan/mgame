package org.mmonahan.mgame.chess.piece;

import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.HashSet;
import java.util.Set;

public class Rook extends ChessPiece {

    public Rook(String id, Player owner) {
        super(id, owner);
    }

    @Override
    public Set<Position> getToPositions(Board board, Position from) {
        Set<Position> rookPositions = new HashSet<>();

        for (int x = from.getX()+1; x <= board.getMaxX(); x++) {
            Position position = new Position(x, from.getY());
            rookPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
        }

        for (int x = from.getX()-1; x > 0; x--) {
            Position position = new Position(x, from.getY());
            rookPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
        }

        for (int y = from.getY()+1; y <= board.getMaxY(); y++) {
            Position position = new Position(from.getX(), y);
            rookPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
        }

        for (int y = from.getY()-1; y > 0; y--) {
            Position position = new Position(from.getX(), y);
            rookPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
        }

        return rookPositions;
    }
}
