import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        final int boundary = 1000;

        while (sum < boundary && scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number != 0) {
                sum = sum + number;
            } else {
                break;
            }
        }
        if (sum < boundary) {
            System.out.println(sum);
        } else {
            System.out.println(sum - boundary);
        }
        
    
    }
}
