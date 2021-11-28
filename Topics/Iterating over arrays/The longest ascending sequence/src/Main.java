import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        if (scanner.hasNext()) {
            String[] arrayStrings = scanner.nextLine().split(" ");
            int[] arrayInts = new int[arrayStrings.length];
        }
        String[] arrayStrings = scanner.nextLine().split(" ");
        int[] arrayInts = new int[arrayStrings.length];

        for (int i = 0; i < arrayStrings.length; i++) {
            arrayInts[i] = Integer.parseInt(arrayStrings[i]);
        }

        int longestSequence = 0;
        int currentSequence = 1;
        for (int i = 1; i < arrayInts.length; i++) {
            if (arrayInts[i] >= arrayInts[i - 1]) {
                currentSequence++;
            } else {
                if (currentSequence > longestSequence) {
                    longestSequence = currentSequence;
                }
                currentSequence = 1;
            }
        }

        if (currentSequence > longestSequence) {
            longestSequence = currentSequence;
        }
        System.out.println(longestSequence);
    }
}