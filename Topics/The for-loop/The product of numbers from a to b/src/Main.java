import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        long product = 1L;

        for (long i = a; i < b; i++) {
            product *= i;
        }

        System.out.println(product);
    }
}