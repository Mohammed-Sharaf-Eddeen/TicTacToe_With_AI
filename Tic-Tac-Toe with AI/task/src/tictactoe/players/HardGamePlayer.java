package tictactoe.players;

import static tictactoe.Game.*;

public class HardGamePlayer extends GamePlayer{

    private final char playerOne;
    private final char playerTwo;

    public HardGamePlayer(char playerOne) {
        this.playerOne = playerOne;
        this.playerTwo = (playerOne == 'X') ? 'O' : 'X';
    }

    @Override
    public int[] play() {
        System.out.println("Making move level \"hard\"");

        int bestScore = -200;
        int[] bestMove = new int[2];

        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = playerOne;
                    int score = minimax(board, false);
                    board[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        //Increase row and col by ones because they are deducted later
                        bestMove = new int[]{i + 1, j + 1};
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(char[][] board, boolean maximizing) {

        int score = winning(board);

        if (score == 10) {
            return score;
        } else if (score == -10) {
            return score;
        } else if (isFinished(board) && score == 0) {
            return score;
        }

        if (maximizing) {
            int bestScore = -100;
            for (int i = 0; i < DIMENSIONS; i++) {
                for (int j = 0; j < DIMENSIONS; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = playerOne;
                        bestScore = Math.max(bestScore, minimax(board, false));
                        board[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 100;
            for (int i = 0; i < DIMENSIONS; i++) {
                for (int j = 0; j < DIMENSIONS; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = playerTwo;
                        bestScore = Math.min(bestScore, minimax(board, true));
                        board[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        }

    }

    private int winning(char[][] board) {
        int streakSumX;
        int streakSumO;

        //checking rows
        for (int i = 0; i < DIMENSIONS; i++) {
            streakSumX = 1;
            streakSumO = 1;
            for (int j = 1; j < DIMENSIONS; j++) {
                if (board[i][j] == board[i][j - 1] && board[i][j] == playerOne) {
                    streakSumX++;
                    if (streakSumX == 3) {
                        return 10;
                    }
                } else if (board[i][j] == board[i][j - 1] && board[i][j] == playerTwo) {
                    streakSumO++;
                    if (streakSumO == 3) {
                        return -10;
                    }
                }
            }
        }

        //checking cols
        for (int j = 0; j < DIMENSIONS; j++) {
            streakSumX = 1;
            streakSumO = 1;
            for (int i = 1; i < DIMENSIONS; i++) {
                if (board[i][j] == board[i - 1][j] && board[i][j] == playerOne) {
                    streakSumX++;
                    if (streakSumX == 3) {
                        return 10;
                    }
                } else if (board[i][j] == board[i - 1][j] && board[i][j] == playerTwo) {
                    streakSumO++;
                    if (streakSumO == 3) {
                        return -10;
                    }
                }
            }
        }

        //checking Diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == playerOne) {
            return 10;
        } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == playerTwo) {
            return -10;
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == playerOne) {
            return 10;
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] == playerTwo) {
            return -10;
        }


        //drawOrIncomplete
        return 0;
    }

    private boolean isFinished(char[][] board) {
        for (int i = 0; i < DIMENSIONS; i++)
            for (int j = 0; j < DIMENSIONS; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

}
