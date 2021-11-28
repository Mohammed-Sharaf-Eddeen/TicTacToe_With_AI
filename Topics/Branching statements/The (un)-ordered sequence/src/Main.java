import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n1 = 0;
        int n2 = scanner.nextInt();
        boolean ascending = false;
        boolean descending = false;

        while (scanner.hasNext()) {
            //test ascending
            n1 = n2;
            n2 = scanner.nextInt();
            if (n2 == 0) {
                break;
            }
            if (n2 == n1) {
                continue;
            }
            if (n2 > n1) {
                ascending = true;
            } else {
                descending = true;
            }
        }
        if (ascending ^ descending) {
            System.out.println("true");
        } else if (!ascending && !descending) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }



    }
}