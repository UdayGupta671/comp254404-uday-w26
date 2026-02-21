package lab3;
import java.util.Scanner;

public class multiply {



	    public static int multiply(int m, int n) {

	     
	        if (n == 0) {
	            return 0;
	        }

	      
	        return m + multiply(m, n - 1);
	    }

	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter first positive integer (m): ");
	        int m = scanner.nextInt();

	        System.out.print("Enter second positive integer (n): ");
	        int n = scanner.nextInt();

	        int result = multiply(m, n);

	        System.out.println("Product = " + result);

	        scanner.close();
	    }
	}
