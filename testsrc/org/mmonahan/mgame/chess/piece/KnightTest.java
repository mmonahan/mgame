package org.mmonahan.mgame.chess.piece;

import org.junit.jupiter.api.Test;
import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    private static Player PLAYER_1 = new Player("Chess 1");

    @Test
    void knightToPositions() {
        Knight knight = new Knight("test", PLAYER_1);
        Board board = new Board(5, 5);
        Set<Position> knightToPositions = knight.getToPositions(board, new Position(3, 3));

        assertEquals(8, knightToPositions.size());
        assertTrue(knightToPositions.contains(new Position(1,2)));
        assertTrue(knightToPositions.contains(new Position(1,4)));
        assertTrue(knightToPositions.contains(new Position(2,1)));
        assertTrue(knightToPositions.contains(new Position(2,5)));
        assertTrue(knightToPositions.contains(new Position(4,1)));
        assertTrue(knightToPositions.contains(new Position(4,5)));
        assertTrue(knightToPositions.contains(new Position(5,2)));
        assertTrue(knightToPositions.contains(new Position(5,4)));
    }
}