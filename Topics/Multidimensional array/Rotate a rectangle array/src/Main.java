import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] firstArray = new int[m][n];
        int[][] secondArray = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                firstArray[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                secondArray[j][m - i] = firstArray[i - 1][j];
            }
        }

        for (int[] ints : secondArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }
}