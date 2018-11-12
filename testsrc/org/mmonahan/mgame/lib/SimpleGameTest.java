package org.mmonahan.mgame.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGameTest {

    private static Player PLAYER_1 = new Player("test name 1");
    private static Player PLAYER_2 = new Player("test name 2");
    private Game testGame;

    @BeforeEach
    void setUp() {
        testGame = new WarpGame(PLAYER_1, PLAYER_2);
    }

    @Test
    void checkPlayersSwitch() {
        assertEquals(PLAYER_1, testGame.getCurrentPlayer());
        testGame.makeMovePosition(new Position(1,1), new Position(2,2));
        assertEquals(PLAYER_2, testGame.getCurrentPlayer());
        testGame.makeMovePosition(new Position(2,2), new Position(1,1));
        assertEquals(PLAYER_1, testGame.getCurrentPlayer());
    }

    @Test
    void testMovesRecorded() {
        Position pos11 = new Position(1,1);
        Position pos22 = new Position(2,2);
        Position pos33 = new Position(3,3);
        Position pos44 = new Position(4,4);
        testGame.makeMovePosition(pos11, pos22);
        testGame.makeMovePosition(pos22, pos33);
        testGame.makeMovePosition(pos33, pos44);

        List<Move> moves = testGame.getMoves();
        assertEquals(3, moves.size());

        assertEquals(pos11, testGame.getMoves().get(0).getResults().get(0).getFromPosition());
        assertEquals(pos22, testGame.getMoves().get(0).getResults().get(0).getToPosition());

        assertEquals(pos22, testGame.getMoves().get(1).getResults().get(0).getFromPosition());
        assertEquals(pos33, testGame.getMoves().get(1).getResults().get(0).getToPosition());

        assertEquals(pos33, testGame.getMoves().get(2).getResults().get(0).getFromPosition());
        assertEquals(pos44, testGame.getMoves().get(2).getResults().get(0).getToPosition());
    }

    class WarpPiece implements Piece {

        String id;
        Player owner;

        public WarpPiece(String id, Player owner) {
            this.id = id;
            this.owner = owner;
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
            Move validMove = new Move("Move " + id + " from " + fromPosition + " to " + toPosition);
            validMove.addResult(this, fromPosition, toPosition);
            return validMove;
        }
    }

    class WarpGame extends Game {

        public WarpGame(Player player1, Player player2) {
            super(player1, player2);
        }

        @Override
        protected void setupBoard() {
            gameBoard = new Board(4,4);
            gameBoard.placePiece(new WarpPiece("warp1", getPlayer1()), new Position(1,1));
        }
    }
}