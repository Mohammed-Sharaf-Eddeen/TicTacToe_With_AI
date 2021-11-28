import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int printNumber;
        int fixed = 0;
        int rejected = 0;
        int perfected = 0;

        for (int i = 0; i < n; i++) {
            printNumber = scanner.nextInt();
            if (printNumber == 1) {
                fixed += 1;
            } else if (printNumber == -1) {
                rejected += 1;
            } else {
                perfected += 1;
            }
        }

        System.out.println(perfected + " " + fixed + " " + rejected);
    }
}
