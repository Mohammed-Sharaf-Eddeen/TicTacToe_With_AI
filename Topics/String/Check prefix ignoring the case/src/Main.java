import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        System.out.println(str.startsWith("j") || str.startsWith("J"));
        
    }
}
