package org.mmonahan.mgame.chess.piece;

import org.junit.jupiter.api.Test;
import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    private static Player PLAYER_1 = new Player("Chess 1");
    private static Player PLAYER_2 = new Player("Chess 2");

    @Test
    void queenToPositions() {
        Queen queen = new Queen("test", PLAYER_1);
        Board board = new Board(5, 5);
        Set<Position> positions = queen.getToPositions(board, new Position(3,3));

        assertEquals(16, positions.size());
        assertTrue(positions.contains(new Position(1,3)));
        assertTrue(positions.contains(new Position(2,3)));
        assertTrue(positions.contains(new Position(4,3)));
        assertTrue(positions.contains(new Position(5,3)));
        assertTrue(positions.contains(new Position(3,1)));
        assertTrue(positions.contains(new Position(3,2)));
        assertTrue(positions.contains(new Position(3,4)));
        assertTrue(positions.contains(new Position(3,5)));
        assertTrue(positions.contains(new Position(1,1)));
        assertTrue(positions.contains(new Position(2,2)));
        assertTrue(positions.contains(new Position(4,4)));
        assertTrue(positions.contains(new Position(5,5)));
        assertTrue(positions.contains(new Position(1,5)));
        assertTrue(positions.contains(new Position(2,4)));
        assertTrue(positions.contains(new Position(4,2)));
        assertTrue(positions.contains(new Position(5,1)));
    }

    @Test
    void queenToPositionsBlocked() {
        Queen queen1 = new Queen("test1", PLAYER_1);
        Queen queen2 = new Queen("test2", PLAYER_2);
        Queen queen3 = new Queen("test3", PLAYER_2);
        Board board = new Board(5, 5);
        board.placePiece(queen2, new Position(4,3));
        board.placePiece(queen3, new Position(4,4));
        Set<Position> positions = queen1.getToPositions(board, new Position(3,3));

        assertEquals(14, positions.size());
        assertTrue(positions.contains(new Position(1,3)));
        assertTrue(positions.contains(new Position(2,3)));
        assertTrue(positions.contains(new Position(4,3)));
        assertFalse(positions.contains(new Position(5,3)));
        assertTrue(positions.contains(new Position(3,1)));
        assertTrue(positions.contains(new Position(3,2)));
        assertTrue(positions.contains(new Position(3,4)));
        assertTrue(positions.contains(new Position(3,5)));
        assertTrue(positions.contains(new Position(1,1)));
        assertTrue(positions.contains(new Position(2,2)));
        assertTrue(positions.contains(new Position(4,4)));
        assertFalse(positions.contains(new Position(5,5)));
        assertTrue(positions.contains(new Position(1,5)));
        assertTrue(positions.contains(new Position(2,4)));
        assertTrue(positions.contains(new Position(4,2)));
        assertTrue(positions.contains(new Position(5,1)));
    }
}