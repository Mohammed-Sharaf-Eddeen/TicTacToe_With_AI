package tictactoe.players;

import java.util.Random;

import static tictactoe.Game.*;
import static tictactoe.Game.board;

public class MediumGamePlayer extends GamePlayer {

    @Override
    public int[] play() {
        System.out.println("Making move level \"medium\"");

        char charOfInterest = getNextMoveType();
        char charOfEnemy = (charOfInterest == 'X') ? 'O' : 'X';

        //finding the finishing move for the player playing now
        int[] coordinates = findFinishingMove(charOfInterest);
        if (coordinates.length != 0) {
            return coordinates;
        }

        //There is no finishing move, so let's find the blocking move for any finishing move that may happen.
        coordinates = findFinishingMove(charOfEnemy);
        if (coordinates.length != 0) {
            return coordinates;
        }

        //There is no finishing or blocking moves, so just play a random move
        return generateComputerMoveEasy();    }

    private int[] findFinishingMove(char XorO) {
        // testing the availability of the finishing move through rows
        char charOfEnemy = (XorO == 'X') ? 'O' : 'X';
        int sumThroughRows = 0;
        int sumThroughCols = 0;
        int rowOfInterest = -1;
        int colOfInterest = -1;
        int sumThroughDiagonals = 0;

        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                if (board[i][j] == XorO) {
                    sumThroughRows += 1;
                } else if (board[i][j] == charOfEnemy) {
                    sumThroughRows -= 1;
                }
            }
            if (sumThroughRows == 2) {
                rowOfInterest = i;
                break;
            } else {
                sumThroughRows = 0;
            }
        }
        // to make sure that the function reached a row of interest
        if (rowOfInterest != -1) {
            for (int j = 0; j < DIMENSIONS; j++) {
                if (board[rowOfInterest][j] == ' ') {
                    return new int[] {rowOfInterest + 1, j + 1};
                }
            }
        }


        // testing the availability of the finishing move through cols
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                //swapping i and j to change the testing from summing rows to summing cols
                if (board[j][i] == XorO) {
                    sumThroughCols += 1;
                } else if (board[j][i] == charOfEnemy) {
                    sumThroughCols -= 1;
                }
            }
            if (sumThroughCols == 2) {
                // col of interest is i not j because we have already swapped it
                colOfInterest = i;
                break;
            } else {
                sumThroughCols = 0;
            }
        }
        // to make sure that the function reached a column of interest
        if (colOfInterest != -1) {
            for (int j = 0; j < DIMENSIONS; j++) {
                if (board[j][colOfInterest] == ' ') {
                    return new int[] {j + 1, colOfInterest + 1};
                }
            }
        }


        //testing the availability of the finishing move through diagonals
        sumThroughDiagonals += (board[0][0] == XorO) ? 1 :
                (board[0][0] == charOfEnemy) ? -1 : 0;
        sumThroughDiagonals += (board[1][1] == XorO) ? 1 :
                (board[1][1] == charOfEnemy) ? -1 : 0;
        sumThroughDiagonals += (board[2][2] == XorO) ? 1 :
                (board[2][2] == charOfEnemy) ? -1 : 0;
        if (sumThroughDiagonals == 2) {
            //returned array elements are increased by one because they are being deducted later
            return (board[0][0] == ' ') ? new int[] {1, 1} :
                    (board[1][1] == ' ') ? new int[] {2, 2} : new int[] {3, 3};
        } else {
            sumThroughDiagonals = 0;
        }

        sumThroughDiagonals += (board[0][2] == XorO) ? 1 :
                (board[0][2] == charOfEnemy) ? -1 : 0;
        sumThroughDiagonals += (board[1][1] == XorO) ? 1 :
                (board[1][1] == charOfEnemy) ? -1 : 0;
        sumThroughDiagonals += (board[2][0] == XorO) ? 1 :
                (board[2][0] == charOfEnemy) ? -1 : 0;
        if (sumThroughDiagonals == 2) {
            //returned array elements are increased by one because they are being deducted later
            return (board[0][2] == ' ') ? new int[] {1, 3} :
                    (board[1][1] == ' ') ? new int[] {2, 2} : new int[] {3, 1};
        }


        //if the method reached this point, it means that there were no cols or rows of interest
        return new int[] {};
    }

    private int[] generateComputerMoveEasy() {
        Random random = new Random();
        boolean empty = false;
        int row = 0;
        int col = 0;

        while (!empty) {
            row = random.nextInt(DIMENSIONS);
            col = random.nextInt(DIMENSIONS);
            if (board[row][col] == ' ') {
                empty = true;
            }
        }
        // adding ones because they are being deducted later
        return new int[] {row + 1, col + 1};
    }



}
