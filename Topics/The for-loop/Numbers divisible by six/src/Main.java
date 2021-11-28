import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int inputSize = sc.nextInt();
        int n;
        int sum = 0;

        for (int i = 0; i < inputSize; i++) {
            n = sc.nextInt();
            if (n % 6 == 0) {
                sum += n;
            }
        }

        System.out.println(sum);
    }
}