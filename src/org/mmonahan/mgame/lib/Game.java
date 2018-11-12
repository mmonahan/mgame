package org.mmonahan.mgame.lib;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private List<Move> moves = new ArrayList<>();
    protected Board gameBoard = new Board(0,0);

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        setupBoard();
    }

    protected abstract void setupBoard();

    /**
     * Move from location to location
     */
    public Move makeMovePosition(Position fromPosition, Position toPosition) {
        Move latestMove = gameBoard.makeMove(currentPlayer, fromPosition, toPosition);
        moves.add(latestMove);

        // update current player if move was valid, otherwise give the current player another try
        if (latestMove.isValid()) {
            currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
        }

        return latestMove;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Board getGameBoard() {
        return gameBoard;
    }
}
