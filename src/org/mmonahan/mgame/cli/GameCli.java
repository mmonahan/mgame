package org.mmonahan.mgame.cli;

import org.mmonahan.mgame.chess.StandardChess;
import org.mmonahan.mgame.lib.*;

import java.util.Scanner;

public class GameCli {

    public static void printBoard(Board board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.getMaxX(); i++) {
            sb.append("----");
        }
        sb.append("-");
        System.out.println(sb.toString());

        for (int y = board.getMaxY(); y > 0; y--) {
            for (int x = 1; x <= board.getMaxX(); x++) {
                Piece piece = board.getPieceAt(new Position(x, y));
                if (piece != null) {
                    System.out.print("|" + piece.getID());
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("| " + y);
            System.out.println(sb.toString());
        }

        for (int i = 1; i <= board.getMaxX(); i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();
    }

    public static void parseInput(String input) {

    }

    public static void main(String[] args) {
        Player player1 = new Player("One");
        Player player2 = new Player("Two");
        Game game = new StandardChess(player1, player2);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Shall we play a game?");
        System.out.println("type the x-y co-ordinates you want to move from and to: #,# #,#");
        printBoard(game.getGameBoard());

        while (true) {
            System.out.println("Enter a move: ");
            String line = scanner.nextLine().trim();
            String[] fromTo = line.split(" ");
            if (fromTo.length != 2) {
                System.out.println("Bad input, please try again");
                continue;
            }
            String[] from = fromTo[0].split(",");
            String[] to = fromTo[1].split(",");
            if (from.length != 2 || to.length != 2) {
                System.out.println("Bad input, please try again");
                continue;
            }
            Position fromPosition = new Position(Integer.parseInt(from[0]), Integer.parseInt(from[1]));
            Position toPosition = new Position(Integer.parseInt(to[0]), Integer.parseInt(to[1]));
            Move move = game.makeMovePosition(fromPosition, toPosition);
            System.out.println(move.getDescription());
            System.out.println("it is " + game.getCurrentPlayer() + "'s turn");
            printBoard(game.getGameBoard());
        }

    }
}
