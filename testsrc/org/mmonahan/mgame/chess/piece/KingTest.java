package org.mmonahan.mgame.chess.piece;

import org.junit.jupiter.api.Test;
import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {

    private static Player PLAYER_1 = new Player("Chess 1");

    @Test
    void rookToPositions() {
        King king = new King("test", PLAYER_1);
        Board board = new Board(5, 5);
        Set<Position> rookToPositions = king.getToPositions(board, new Position(3, 3));

        assertEquals(8, rookToPositions.size());
        assertTrue(rookToPositions.contains(new Position(2,2)));
        assertTrue(rookToPositions.contains(new Position(2,3)));
        assertTrue(rookToPositions.contains(new Position(2,4)));
        assertTrue(rookToPositions.contains(new Position(3,2)));
        assertTrue(rookToPositions.contains(new Position(3,4)));
        assertTrue(rookToPositions.contains(new Position(4,2)));
        assertTrue(rookToPositions.contains(new Position(4,3)));
        assertTrue(rookToPositions.contains(new Position(4,4)));
    }
}