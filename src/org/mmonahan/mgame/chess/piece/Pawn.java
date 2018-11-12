package org.mmonahan.mgame.chess.piece;

import org.mmonahan.mgame.lib.*;

import java.util.HashSet;
import java.util.Set;

public class Pawn implements Piece {

    public enum Direction {UP, DOWN}

    private String id;
    private Player owner;
    private Direction moveDirection;

    public Pawn(String id, Player owner, Direction moveDirection) {
        this.id = id;
        this.owner = owner;
        this.moveDirection = moveDirection;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public Move makeMove(Player player, Board board, Position fromPosition, Position toPosition) {
        if (!owner.equals(player)) {
            return new Move(player + " may not move " + id);
        }

        if (fromPosition.equals(toPosition)) {
            return new Move("Chess pieces cannot stay in the same place");
        }

        //Pawns can move forward with nothing blocking them
        Position forwardPosition = getForwardPosition(fromPosition);
        if (forwardPosition.equals(toPosition) && board.getPieceAt(forwardPosition) == null) {
            Move moveToOpenSpace = new Move("Moving " + id + " to " + toPosition);
            moveToOpenSpace.addResult(this, fromPosition, toPosition);
            return moveToOpenSpace;
        }

        //Pawns can move diagonal to take an opponent's piece
        Set<Position> takePositions = getTakePositions(fromPosition);
        Piece takePiece = board.getPieceAt(toPosition);
        if (takePositions.contains(toPosition) && takePiece != null && !takePiece.getOwner().equals(player)) {
            Move moveToTakePiece = new Move("Moving " + id + " to " + toPosition
                    + ", taking " + takePiece.getID());
            moveToTakePiece.addResult(this, fromPosition, toPosition);
            moveToTakePiece.addResult(takePiece, toPosition, Board.REMOVE_FROM_BOARD);
            return moveToTakePiece;
        }

        //TODO: add en passant and promotion
        return new Move(id + " cannot move to " + toPosition);
    }

    private Position getForwardPosition(Position from) {
        Position forward;
        if (moveDirection == Direction.UP) {
            forward = new Position(from.getX(), from.getY() + 1);
        } else {
            forward = new Position(from.getX(), from.getY() - 1);
        }
        return forward;
    }

    private Set<Position> getTakePositions(Position from) {
        Set<Position> takePositions = new HashSet<>();
        if (moveDirection == Direction.UP) {
            takePositions.add(new Position(from.getX() + 1, from.getY() + 1));
            takePositions.add(new Position(from.getX() - 1, from.getY() + 1));
        } else {
            takePositions.add(new Position(from.getX() + 1, from.getY() - 1));
            takePositions.add(new Position(from.getX() - 1, from.getY() - 1));
        }
        return  takePositions;
    }
}
