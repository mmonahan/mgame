package org.mmonahan.mgame.chess.piece;

import org.junit.jupiter.api.Test;
import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    private static Player PLAYER_1 = new Player("Chess 1");
    private static Player PLAYER_2 = new Player("Chess 2");

    @Test
    void rookToPositions() {
        Bishop bishop = new Bishop("test", PLAYER_1);
        Board board = new Board(5, 5);
        Set<Position> bishopToPositions = bishop.getToPositions(board, new Position(3, 3));

        assertEquals(8, bishopToPositions.size());
        assertTrue(bishopToPositions.contains(new Position(1,1)));
        assertTrue(bishopToPositions.contains(new Position(2,2)));
        assertTrue(bishopToPositions.contains(new Position(4,4)));
        assertTrue(bishopToPositions.contains(new Position(5,5)));
        assertTrue(bishopToPositions.contains(new Position(1,5)));
        assertTrue(bishopToPositions.contains(new Position(2,4)));
        assertTrue(bishopToPositions.contains(new Position(4,2)));
        assertTrue(bishopToPositions.contains(new Position(5,1)));
    }

    @Test
    void rookToPositionsBlocked() {
        Bishop bishop1 = new Bishop("test", PLAYER_1);
        Bishop bishop2 = new Bishop("block", PLAYER_2);
        Board board = new Board(5, 5);
        board.placePiece(bishop2, new Position(4,4));
        Set<Position> bishopToPositions = bishop1.getToPositions(board, new Position(3, 3));

        assertEquals(7, bishopToPositions.size());
        assertTrue(bishopToPositions.contains(new Position(1,1)));
        assertTrue(bishopToPositions.contains(new Position(2,2)));
        assertTrue(bishopToPositions.contains(new Position(4,4)));
        assertFalse(bishopToPositions.contains(new Position(5,5)));
        assertTrue(bishopToPositions.contains(new Position(1,5)));
        assertTrue(bishopToPositions.contains(new Position(2,4)));
        assertTrue(bishopToPositions.contains(new Position(4,2)));
        assertTrue(bishopToPositions.contains(new Position(5,1)));
    }
}