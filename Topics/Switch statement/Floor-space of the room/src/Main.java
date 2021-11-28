import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        final double PI = 3.14;
        final double root = 0.5;
        char[] array = new char[0];
        char[] arraya = new char[10000000000000];

        switch (option) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double s = (a + b + c) / 2;
                double area = Math.pow(s * (s - a) * (s - b) * (s - c), root);
                System.out.println(area);
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                area = a * b;
                System.out.println(area);
                break;
            case "circle":
                a = scanner.nextDouble();
                area = PI * a * a;
                System.out.println(area);
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }
}