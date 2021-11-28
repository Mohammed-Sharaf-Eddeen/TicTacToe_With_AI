package tictactoe.players;

import java.util.Random;

import static tictactoe.Game.DIMENSIONS;
import static tictactoe.Game.board;

public class EasyGamePlayer extends GamePlayer {

    @Override
    public int[] play() {
        System.out.println("Making move level \"easy\"");

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
