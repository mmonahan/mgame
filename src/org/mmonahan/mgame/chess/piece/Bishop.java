package org.mmonahan.mgame.chess.piece;

import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends ChessPiece {

    public Bishop(String id, Player owner) {
        super(id, owner);
    }

    @Override
    public Set<Position> getToPositions(Board board, Position from) {
        Set<Position> bishopPositions = new HashSet<>();

        int x = from.getX() + 1;
        int y = from.getY() + 1;
        while (x <= board.getMaxX() && y <= board.getMaxY()) {
            Position position = new Position(x, y);
            bishopPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
            x++;
            y++;
        }

        x = from.getX() + 1;
        y = from.getY() - 1;
        while (x <= board.getMaxX() && y > 0) {
            Position position = new Position(x, y);
            bishopPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
            x++;
            y--;
        }

        x = from.getX() - 1;
        y = from.getY() - 1;
        while (x > 0 && y > 0) {
            Position position = new Position(x, y);
            bishopPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
            x--;
            y--;
        }

        x = from.getX() - 1;
        y = from.getY() + 1;
        while (x > 0 && y <= board.getMaxY()) {
            Position position = new Position(x, y);
            bishopPositions.add(position);
            if (board.getPieceAt(position) != null) {
                break;
            }
            x--;
            y++;
        }

        return bishopPositions;
    }
}
