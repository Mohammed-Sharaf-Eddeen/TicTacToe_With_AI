import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(str.substring(scanner.nextInt(), scanner.nextInt() + 1));
    }
}