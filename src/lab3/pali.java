package lab3;

import java.util.Scanner;

public class pali {
	

	    public static boolean isPalindrome(String s) {

	        if (s.length() <= 1) {
	            return true;
	        }

	       
	        if (s.charAt(0) != s.charAt(s.length() - 1)) {
	            return false;
	        }

	        return isPalindrome(s.substring(1, s.length() - 1));
	    }


	    public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a string to check: ");
	        String input = scanner.nextLine();

	        if (isPalindrome(input)) {
	            System.out.println("The string is a palindrome.");
	        } else {
	            System.out.println("The string is NOT a palindrome.");
	        }

	        scanner.close();
	    }
	}
