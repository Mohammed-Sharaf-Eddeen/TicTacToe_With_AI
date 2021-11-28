package tictactoe;

import tictactoe.players.GamePlayer;

public class Game {

    public static final int DIMENSIONS = 3;
    public static char[][] board = new char[DIMENSIONS][DIMENSIONS];

    private final GamePlayer playerOne;
    private final GamePlayer playerTwo;
    private boolean finished = false;

    public void start() {
        initializeBoard();
        printBoard();

        while (!finished) {
            // player one playing his own move
            int[] currentCoordinates = playerOne.play();
            makeNextMove(currentCoordinates, getNextMoveType());
            printBoard();
            finished = checkGameStatus();
            if (finished) {
                break;
            }
            // player two playing his own move
            currentCoordinates = playerTwo.play();
            makeNextMove(currentCoordinates, getNextMoveType());
            printBoard();
            finished = checkGameStatus();
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() {
        System.out.println("---------");

        for (int i = 0; i < DIMENSIONS; i++) {
            System.out.print("| ");
            for (int j = 0; j < DIMENSIONS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }

        System.out.println("---------");
    }

    private void makeNextMove(int[] coordinates, char XorO) {
        int row = coordinates[0] - 1;
        int col = coordinates[1] - 1;
        board[row][col] = XorO;
    }

    public static char getNextMoveType() {
        int sumX = 0;
        int sumO = 0;

        for (char[] chArray : board) {
            for (char ch : chArray) {
                if (ch == 'X') {
                    sumX++;
                } else if (ch == 'O') {
                    sumO++;
                }
            }
        }

        return (sumX <= sumO) ? 'X' : 'O';

    }

    private boolean checkGameStatus() {
        int streakSumX;
        int streakSumO;

        //checking rows
        for (int i = 0; i < DIMENSIONS; i++) {
            streakSumX = 1;
            streakSumO = 1;
            for (int j = 1; j < DIMENSIONS; j++) {
                if (board[i][j] == board[i][j - 1] && board[i][j] == 'X') {
                    streakSumX++;
                    if (streakSumX == 3) {
                        System.out.println("X wins");
                        System.out.println();
                        return true;
                    }
                } else if (board[i][j] == board[i][j - 1] && board[i][j] == 'O') {
                    streakSumO++;
                    if (streakSumO == 3) {
                        System.out.println("O wins");
                        System.out.println();
                        return true;
                    }
                }
            }
        }

        //checking cols
        for (int j = 0; j < DIMENSIONS; j++) {
            streakSumX = 1;
            streakSumO = 1;
            for (int i = 1; i < DIMENSIONS; i++) {
                if (board[i][j] == board[i - 1][j] && board[i][j] == 'X') {
                    streakSumX++;
                    if (streakSumX == 3) {
                        System.out.println("X wins");
                        System.out.println();
                        return true;
                    }
                } else if (board[i][j] == board[i - 1][j] && board[i][j] == 'O') {
                    streakSumO++;
                    if (streakSumO == 3) {
                        System.out.println("O wins");
                        System.out.println();
                        return true;
                    }
                }
            }
        }

        //checking Diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == 'X') {
            System.out.println("X wins");
            System.out.println();
            return true;
        } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == 'O') {
            System.out.println("O wins");
            System.out.println();
            return true;
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == 'X') {
            System.out.println("X wins");
            System.out.println();
            return true;
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == 'O') {
            System.out.println("O wins");
            System.out.println();
            return true;
        }

        // checking Draws
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        System.out.println("Draw");
        System.out.println();
        return true;
    }

    public Game(GamePlayer playerOne, GamePlayer playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

}
