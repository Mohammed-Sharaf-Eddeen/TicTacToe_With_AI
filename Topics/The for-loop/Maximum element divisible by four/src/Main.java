import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int currentNumber = 0;
        int biggestNumber = 0;

        for (int i = 0; i < n; i++) {
            currentNumber = scanner.nextInt();
            if (currentNumber % 4 == 0 && currentNumber > biggestNumber) {
                biggestNumber = currentNumber;
            }
        }

        System.out.println(biggestNumber);
    }
}