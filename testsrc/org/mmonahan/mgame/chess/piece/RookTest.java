package org.mmonahan.mgame.chess.piece;

import org.junit.jupiter.api.Test;
import org.mmonahan.mgame.lib.Board;
import org.mmonahan.mgame.lib.Player;
import org.mmonahan.mgame.lib.Position;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private static Player PLAYER_1 = new Player("Chess 1");
    private static Player PLAYER_2 = new Player("Chess 2");

    @Test
    void rookToPositions() {
        Rook rook = new Rook("test", PLAYER_1);
        Board board = new Board(5, 5);
        Set<Position> rookToPositions = rook.getToPositions(board, new Position(3, 3));

        assertEquals(8, rookToPositions.size());
        assertTrue(rookToPositions.contains(new Position(1,3)));
        assertTrue(rookToPositions.contains(new Position(2,3)));
        assertTrue(rookToPositions.contains(new Position(4,3)));
        assertTrue(rookToPositions.contains(new Position(5,3)));
        assertTrue(rookToPositions.contains(new Position(3,1)));
        assertTrue(rookToPositions.contains(new Position(3,2)));
        assertTrue(rookToPositions.contains(new Position(3,4)));
        assertTrue(rookToPositions.contains(new Position(3,5)));
    }

    @Test
    void rookToPositionsBlocked() {
        Rook rook1 = new Rook("test", PLAYER_1);
        Rook rook2 = new Rook("block", PLAYER_2);
        Board board = new Board(5, 5);
        board.placePiece(rook2, new Position(4,3));
        Set<Position> rookToPositions = rook1.getToPositions(board, new Position(3, 3));

        assertEquals(7, rookToPositions.size());
        assertTrue(rookToPositions.contains(new Position(1,3)));
        assertTrue(rookToPositions.contains(new Position(2,3)));
        assertTrue(rookToPositions.contains(new Position(4,3)));
        assertFalse(rookToPositions.contains(new Position(5,3)));
        assertTrue(rookToPositions.contains(new Position(3,1)));
        assertTrue(rookToPositions.contains(new Position(3,2)));
        assertTrue(rookToPositions.contains(new Position(3,4)));
        assertTrue(rookToPositions.contains(new Position(3,5)));
    }
}