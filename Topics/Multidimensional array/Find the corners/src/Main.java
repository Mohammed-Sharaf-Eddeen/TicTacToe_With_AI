class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here
        int firstRow = 0;
        int firstColumn = 0;
        int lastRow = twoDimArray.length - 1;
        int lastColumn = twoDimArray[0].length - 1;

        System.out.print(twoDimArray[firstRow][firstColumn] + " " + twoDimArray[firstRow][lastColumn]);
        System.out.println();
        System.out.print(twoDimArray[lastRow][firstColumn] + " " + twoDimArray[lastRow][lastColumn]);

    }
}