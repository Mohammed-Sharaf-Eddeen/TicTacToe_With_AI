import java.util.Scanner;  // Import the Scanner class

public class Main {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int count = 0;
	    int a = scanner.nextInt();
	    int b = scanner.nextInt();
	    int n = scanner.nextInt();
	    
	    for (int i = a; i <= b; i++) {
	        if (i % n == 0) {
	          count += 1;  
	        }
	    }
		System.out.println(count);
	}
}
