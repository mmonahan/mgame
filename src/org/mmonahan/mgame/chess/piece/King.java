package org.mmonahan.mgame.chess.piece;

import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.HashSet;
import java.util.Set;

public class King extends ChessPiece {

    public King(String id, Player owner) {
        super(id, owner);
    }

    @Override
    public Set<Position> getToPositions(Board board, Position from) {
        Set<Position> kingEndPositions = new HashSet<>();
        kingEndPositions.add(new Position(from.getX()+1, from.getY()));
        kingEndPositions.add(new Position(from.getX()-1, from.getY()));
        kingEndPositions.add(new Position(from.getX(), from.getY()+1));
        kingEndPositions.add(new Position(from.getX(), from.getY()-1));
        kingEndPositions.add(new Position(from.getX()+1, from.getY()+1));
        kingEndPositions.add(new Position(from.getX()+1, from.getY()-1));
        kingEndPositions.add(new Position(from.getX()-1, from.getY()+1));
        kingEndPositions.add(new Position(from.getX()-1, from.getY()-1));
        return kingEndPositions;
    }
}
