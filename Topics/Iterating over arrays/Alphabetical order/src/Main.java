import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean ordered = true;
        String input = scanner.nextLine();
        String[] words = input.split(" ");

        for (int i = 1; i < words.length; i++) {
            if (words[i].compareTo(words[i - 1]) < 0) {
                ordered = false;
                break;
            }
        }

        System.out.println(ordered);
    }
}