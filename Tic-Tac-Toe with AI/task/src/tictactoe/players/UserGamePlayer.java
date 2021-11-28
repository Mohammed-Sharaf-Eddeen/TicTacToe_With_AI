package tictactoe.players;

import tictactoe.Game;

import java.util.Scanner;

import static tictactoe.Game.DIMENSIONS;
import static tictactoe.Main.scanner;

public class UserGamePlayer extends GamePlayer{

    @Override
    public int[] play() {
        System.out.print("Enter the coordinates: > ");

        int[] coordinates = new int[2];
        int i;

        while (scanner.hasNext()) {
            Scanner sc = new Scanner(scanner.nextLine().trim());
            i = 0;
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n <= DIMENSIONS && n > 0 && i <= 1) {
                    coordinates[i++] = n;
                }

            }

            //If the above loop got broken at first which means no numbers at all have been entered.
            if (i == 0) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates: > ");
            } //if the above loop got broken at some point without having correct input of two numbers
            else if (i == 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.print("Enter the coordinates: > ");
            } //if the above loop got the two numbers correctly
            else if (i == 2) {
                int row = coordinates[0] - 1;
                int col = coordinates[1] - 1;
                if (Game.board[row][col] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates: > ");
                } else {
                    break;
                }
            }
        }
        return coordinates;
    }
}
