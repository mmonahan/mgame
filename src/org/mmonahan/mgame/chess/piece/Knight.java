package org.mmonahan.mgame.chess.piece;

import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.HashSet;
import java.util.Set;

public class Knight extends ChessPiece {

    public Knight(String id, Player owner) {
        super(id, owner);
    }

    @Override
    public Set<Position> getToPositions(Board board, Position from) {
        Set<Position> knightEndPositions = new HashSet<>();
        knightEndPositions.add(new Position(from.getX()+2, from.getY()+1));
        knightEndPositions.add(new Position(from.getX()+2, from.getY()-1));

        knightEndPositions.add(new Position(from.getX()-2, from.getY()+1));
        knightEndPositions.add(new Position(from.getX()-2, from.getY()-1));

        knightEndPositions.add(new Position(from.getX()+1, from.getY()+2));
        knightEndPositions.add(new Position(from.getX()-1, from.getY()+2));

        knightEndPositions.add(new Position(from.getX()+1, from.getY()-2));
        knightEndPositions.add(new Position(from.getX()-1, from.getY()-2));

        return knightEndPositions;
    }
}
