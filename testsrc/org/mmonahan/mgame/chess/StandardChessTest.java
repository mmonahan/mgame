package org.mmonahan.mgame.chess;

import org.junit.jupiter.api.Test;
import org.mmonahan.mgame.lib.*;

import static org.junit.jupiter.api.Assertions.*;

class StandardChessTest {

    private static Player PLAYER_1 = new Player("Chess 1");
    private static Player PLAYER_2 = new Player("Chess 2");

    @Test
    void testSimpleGame() {
        Move latestMove;
        Game testGame = new StandardChess(PLAYER_1, PLAYER_2);
        Board board = testGame.getGameBoard();

        //valid first move
        latestMove = testGame.makeMovePosition(new Position(4,2), new Position(4,3));
        assertTrue(latestMove.isValid());
        assertEquals("wp4", board.getPieceAt(new Position(4,3)).getID());

        //invalid second move, player two may not move player one's piece, player two keeps turn
        latestMove = testGame.makeMovePosition(new Position(4,3), new Position(4,4));
        assertFalse(latestMove.isValid());
        assertEquals(PLAYER_2, testGame.getCurrentPlayer());
        assertEquals("wp4", board.getPieceAt(new Position(4,3)).getID());

        //move knight over pawns
        latestMove = testGame.makeMovePosition(new Position(7,8), new Position(8,6));
        assertTrue(latestMove.isValid());
        assertEquals("bk2", board.getPieceAt(new Position(8,6)).getID());

        //bishop takes knight
        latestMove = testGame.makeMovePosition(new Position(3,1), new Position(8,6));
        assertTrue(latestMove.isValid());
        assertEquals("wb1", board.getPieceAt(new Position(8,6)).getID());

        //pawn tries to take bishop by moving forward, not allowed
        latestMove = testGame.makeMovePosition(new Position(8,7), new Position(8,6));
        assertFalse(latestMove.isValid());
        assertEquals(PLAYER_2, testGame.getCurrentPlayer());
        assertEquals("wb1", board.getPieceAt(new Position(8,6)).getID());

        //pawn takes bishop by moving diagonally
        latestMove = testGame.makeMovePosition(new Position(7,7), new Position(8,6));
        assertTrue(latestMove.isValid());
        assertEquals("bp7", board.getPieceAt(new Position(8,6)).getID());
    }

}