package lab2;

public class bigOh {
	/** 
	   * example1
	   * Big-Oh: O(n)
	   * Explanation:
	   * There is a single loop that runs from 0 to n-1.
	   * Each iteration does a constant-time operation (addition).
	   * Therefore, total running time grows linearly with n.
	   */
	  public static int example1(int[] arr) {
	    int n = arr.length, total = 0;
	    for (int j=0; j < n; j++)       // runs n times
	      total += arr[j];             // constant time
	    return total;
	  }

	  /** 
	   * example2
	   * Big-Oh: O(n)
	   * Explanation:
	   * The loop increments by 2 (j += 2), so it runs about n/2 times.
	   * Constants are ignored in Big-Oh notation.
	   * Therefore, O(n/2) simplifies to O(n).
	   */
	  public static int example2(int[] arr) {
	    int n = arr.length, total = 0;
	    for (int j=0; j < n; j += 2)    // runs about n/2 times
	      total += arr[j];
	    return total;
	  }

	  /** 
	   * example3
	   * Big-Oh: O(n^2)
	   * Explanation:
	   * Outer loop runs n times.
	   * Inner loop runs j+1 times.
	   * Total operations = 1 + 2 + 3 + ... + n
	   * This equals n(n+1)/2.
	   * Dropping constants and lower-order terms gives O(n^2).
	   */
	  public static int example3(int[] arr) {
	    int n = arr.length, total = 0;
	    for (int j=0; j < n; j++)       
	      for (int k=0; k <= j; k++)    
	        total += arr[j];
	    return total;
	  }

	  /** 
	   * example4
	   * Big-Oh: O(n)
	   * Explanation:
	   * Although this computes prefix sums, it uses only one loop.
	   * Each iteration performs constant-time work.
	   * Therefore, total running time is linear: O(n).
	   */
	  public static int example4(int[] arr) {
	    int n = arr.length, prefix = 0, total = 0;
	    for (int j=0; j < n; j++) {     
	      prefix += arr[j];
	      total += prefix;
	    }
	    return total;
	  }

	  /** 
	   * example5
	   * Big-Oh: O(n^3)
	   * Explanation:
	   * Outer loop runs n times.
	   * Inside it:
	   *   Second loop runs n times.
	   *   Third loop runs up to n times.
	   * So inner work is n * n = n^2.
	   * Since this is inside another loop of n,
	   * total time = n * n^2 = n^3.
	   * Therefore, O(n^3).
	   */
	  public static int example5(int[] first, int[] second) { 
	    int n = first.length, count = 0;
	    for (int i=0; i < n; i++) {     
	      int total = 0;
	      for (int j=0; j < n; j++)     
	        for (int k=0; k <= j; k++)  
	          total += first[k];
	      if (second[i] == total) count++;
	    }
	    return count;
	  }

}
