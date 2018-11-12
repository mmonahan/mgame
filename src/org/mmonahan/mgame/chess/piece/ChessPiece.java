package org.mmonahan.mgame.chess.piece;

import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Move;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;
import org.mmonahan.mgame.lib.Piece;

import java.util.Set;

public abstract class ChessPiece implements Piece {

    private String id;
    private Player owner;

    public ChessPiece(String id, Player owner) {
        this.id = id;
        this.owner = owner;
    }

    @Override
    public Move makeMove(Player player, Board board, Position fromPosition, Position toPosition) {
        if (!owner.equals(player)) {
            return new Move(player + " may not move " + id);
        }

        if (fromPosition.equals(toPosition)) {
            return new Move("Chess pieces cannot stay in the same place");
        }

        Set<Position> toPositions = getToPositions(board, fromPosition);
        if (!toPositions.contains(toPosition)) {
            return new Move(id + " cannot move to " + toPosition);
        }

        Piece pieceAtTo = board.getPieceAt(toPosition);
        if (pieceAtTo == null) {
            //Move is valid, and to an open space
            Move moveToOpenSpace = new Move("Moving " + id + " to " + toPosition);
            moveToOpenSpace.addResult(this, fromPosition, toPosition);
            return moveToOpenSpace;
        } else if (!pieceAtTo.getOwner().equals(player)) {
            //Move is valid and takes opponent's piece
            Move moveToTakePiece = new Move("Moving " + id + " to " + toPosition
                    + ", taking " + pieceAtTo.getID());
            moveToTakePiece.addResult(this, fromPosition, toPosition);
            moveToTakePiece.addResult(pieceAtTo, toPosition, Board.REMOVE_FROM_BOARD);
            return moveToTakePiece;
        } else {
            //Move is attempting to take own piece
            return new Move(id + " may not take friendly piece " + pieceAtTo.getID());
        }
    }

    public abstract Set<Position> getToPositions(Board board, Position from);

    @Override
    public String getID() {
        return id;
    }

    @Override
    public Player getOwner() {
        return owner;
    }
}
