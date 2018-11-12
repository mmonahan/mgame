package org.mmonahan.mgame.chess;

import org.mmonahan.mgame.chess.piece.*;
import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Game;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

public class StandardChess extends Game {

    public static int STANDARD_SIZE = 8;

    public StandardChess(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    protected void setupBoard() {
        gameBoard = new Board(STANDARD_SIZE, STANDARD_SIZE);

        //Player 1 pieces (white)
        gameBoard.placePiece(new Rook("wr1", getPlayer1()), new Position(1,1));
        gameBoard.placePiece(new Knight("wk1", getPlayer1()), new Position(2,1));
        gameBoard.placePiece(new Bishop("wb1", getPlayer1()), new Position(3,1));
        gameBoard.placePiece(new King("wki", getPlayer1()), new Position(4,1));
        gameBoard.placePiece(new Queen("wqu", getPlayer1()), new Position(5,1));
        gameBoard.placePiece(new Bishop("wb2", getPlayer1()), new Position(6,1));
        gameBoard.placePiece(new Knight("wk2", getPlayer1()), new Position(7,1));
        gameBoard.placePiece(new Rook("wr2", getPlayer1()), new Position(8,1));
        for (int i = 1; i <= STANDARD_SIZE; i++) {
            gameBoard.placePiece(new Pawn("wp" + i, getPlayer1(), Pawn.Direction.UP), new Position(i,2));
        }

        //Player 2 pieces (black)
        gameBoard.placePiece(new Rook("br1", getPlayer2()), new Position(1,8));
        gameBoard.placePiece(new Knight("bk1", getPlayer2()), new Position(2,8));
        gameBoard.placePiece(new Bishop("bb1", getPlayer2()), new Position(3,8));
        gameBoard.placePiece(new King("bki", getPlayer2()), new Position(4,8));
        gameBoard.placePiece(new Queen("bqu", getPlayer2()), new Position(5,8));
        gameBoard.placePiece(new Bishop("bb2", getPlayer2()), new Position(6,8));
        gameBoard.placePiece(new Knight("bk2", getPlayer2()), new Position(7,8));
        gameBoard.placePiece(new Rook("br2", getPlayer2()), new Position(8,8));
        for (int i = 1; i <= STANDARD_SIZE; i++) {
            gameBoard.placePiece(new Pawn("bp" + i, getPlayer2(), Pawn.Direction.DOWN), new Position(i, 7));
        }
    }
}
