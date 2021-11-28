package tictactoe;

import tictactoe.players.*;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        GamePlayer playerOne;
        GamePlayer playerTwo;

        System.out.print("Input command: > ");

        while (scanner.hasNext()) {
            String[] menuInput = scanner.nextLine().trim().split(" ");

            if (menuInput[0].equals("exit")) {
                break;
            } else if (menuInput[0].equals("start") && menuInput.length == 3) {

                switch (menuInput[1]) {
                    case "user":
                        playerOne = new UserGamePlayer();
                        break;
                    case "easy":
                        playerOne = new EasyGamePlayer();
                        break;
                    case "medium":
                        playerOne = new MediumGamePlayer();
                        break;
                    case "hard":
                        playerOne = new HardGamePlayer('X');
                        break;
                    default:
                        System.out.println("Bad parameters!");
                        System.out.print("Input command: > ");
                        continue;
                }

                switch (menuInput[2]) {
                    case "user": {
                        playerTwo = new UserGamePlayer();
                        Game game = new Game(playerOne, playerTwo);
                        game.start();
                        System.out.print("Input command: > ");
                        break;
                    }
                    case "easy": {
                        playerTwo = new EasyGamePlayer();
                        Game game = new Game(playerOne, playerTwo);
                        game.start();
                        System.out.print("Input command: > ");
                        break;
                    }
                    case "medium": {
                        playerTwo = new MediumGamePlayer();
                        Game game = new Game(playerOne, playerTwo);
                        game.start();
                        System.out.print("Input command: > ");
                        break;
                    }
                    case "hard": {
                        playerTwo = new HardGamePlayer('O');
                        Game game = new Game(playerOne, playerTwo);
                        game.start();
                        System.out.print("Input command: > ");
                        break;
                    }
                    default:
                        System.out.println("Bad parameters!");
                        System.out.print("Input command: > ");
                        break;
                }
            }
            else {
                System.out.println("Bad parameters!");
                System.out.print("Input command: > ");
            }
        }


    }

}
