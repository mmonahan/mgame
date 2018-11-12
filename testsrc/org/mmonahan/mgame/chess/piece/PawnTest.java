package org.mmonahan.mgame.chess.piece;

import org.junit.jupiter.api.Test;
import org.mmonahan.mgame.lib.*;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    private static Player PLAYER_1 = new Player("Chess 1");
    private static Player PLAYER_2 = new Player("Chess 2");

    @Test
    void moveUp() {
        Pawn pawn1 = new Pawn("p1", PLAYER_1, Pawn.Direction.UP);

        Game testGame = new Game(PLAYER_1, PLAYER_2) {
            @Override
            protected void setupBoard() {
                gameBoard = new Board(2, 1);
                gameBoard.placePiece(pawn1, new Position(1,1));
            }
        };

        testGame.makeMovePosition(new Position(1,1), new Position(1,2));

        assertTrue(testGame.getMoves().get(0).isValid());
        assertEquals(pawn1, testGame.getGameBoard().getPieceAt(new Position(1,2)));
    }

    @Test
    void moveDown() {
        Pawn pawn1 = new Pawn("p1", PLAYER_1, Pawn.Direction.DOWN);

        Game testGame = new Game(PLAYER_1, PLAYER_2) {
            @Override
            protected void setupBoard() {
                gameBoard = new Board(2, 1);
                gameBoard.placePiece(pawn1, new Position(1,2));
            }
        };

        testGame.makeMovePosition(new Position(1,2), new Position(1,1));

        assertTrue(testGame.getMoves().get(0).isValid());
        assertEquals(pawn1, testGame.getGameBoard().getPieceAt(new Position(1,1)));
    }

    @Test
    void takeUP() {
        Pawn pawn1 = new Pawn("p1", PLAYER_1, Pawn.Direction.UP);
        Pawn pawn2 = new Pawn("p2", PLAYER_2, Pawn.Direction.DOWN);
        Pawn pawn3 = new Pawn("p3", PLAYER_2, Pawn.Direction.DOWN);

        Game testGame = new Game(PLAYER_1, PLAYER_2) {
            @Override
            protected void setupBoard() {
                gameBoard = new Board(2, 3);
                gameBoard.placePiece(pawn1, new Position(2,1));
                gameBoard.placePiece(pawn2, new Position(1,2));
                gameBoard.placePiece(pawn3, new Position(3,2));
            }
        };

        testGame.makeMovePosition(new Position(2,1), new Position(1,2));

        assertTrue(testGame.getMoves().get(0).isValid());
        assertEquals(pawn1, testGame.getGameBoard().getPieceAt(new Position(1,2)));

        testGame = new Game(PLAYER_1, PLAYER_2) {
            @Override
            protected void setupBoard() {
                gameBoard = new Board(2, 3);
                gameBoard.placePiece(pawn1, new Position(2,1));
                gameBoard.placePiece(pawn2, new Position(1,2));
                gameBoard.placePiece(pawn3, new Position(3,2));
            }
        };

        testGame.makeMovePosition(new Position(2,1), new Position(3,2));

        assertTrue(testGame.getMoves().get(0).isValid());
        assertEquals(pawn1, testGame.getGameBoard().getPieceAt(new Position(3,2)));
    }

    @Test
    void takeDown() {
        Pawn pawn1 = new Pawn("p1", PLAYER_1, Pawn.Direction.DOWN);
        Pawn pawn2 = new Pawn("p2", PLAYER_2, Pawn.Direction.UP);
        Pawn pawn3 = new Pawn("p3", PLAYER_2, Pawn.Direction.UP);

        Game testGame = new Game(PLAYER_1, PLAYER_2) {
            @Override
            protected void setupBoard() {
                gameBoard = new Board(2, 3);
                gameBoard.placePiece(pawn1, new Position(2,2));
                gameBoard.placePiece(pawn2, new Position(1,1));
                gameBoard.placePiece(pawn3, new Position(3,1));
            }
        };

        testGame.makeMovePosition(new Position(2,2), new Position(1,1));

        assertTrue(testGame.getMoves().get(0).isValid());
        assertEquals(pawn1, testGame.getGameBoard().getPieceAt(new Position(1,1)));

        testGame = new Game(PLAYER_1, PLAYER_2) {
            @Override
            protected void setupBoard() {
                gameBoard = new Board(2, 3);
                gameBoard.placePiece(pawn1, new Position(2,2));
                gameBoard.placePiece(pawn2, new Position(1,1));
                gameBoard.placePiece(pawn3, new Position(3,1));
            }
        };

        testGame.makeMovePosition(new Position(2,2), new Position(3,1));

        assertTrue(testGame.getMoves().get(0).isValid());
        assertEquals(pawn1, testGame.getGameBoard().getPieceAt(new Position(3,1)));
    }
}