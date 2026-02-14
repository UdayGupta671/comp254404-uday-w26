package lab2;

	import java.util.Arrays;


	public class unique {
		 /** Returns true if there are no duplicate elements in the array. */
		  public static boolean unique1(int[] data) {
		    int n = data.length;                     // get array length
		    for (int j=0; j < n-1; j++)              // outer loop
		      for (int k=j+1; k < n; k++)            // inner loop
		        if (data[j] == data[k])              // compare pair
		          return false;                      // duplicate found
		    return true;                             // no duplicates
		  }

		  /** Returns true if there are no duplicate elements in the array. */
		  public static boolean unique2(int[] data) {
		    int n = data.length;                     
		    int[] temp = Arrays.copyOf(data, n);     // copy original array
		    Arrays.sort(temp);                       // sort copied array
		    for (int j=0; j < n-1; j++)              // check neighbors
		      if (temp[j] == temp[j+1])
		        return false;                        
		    return true;                             
		  }

		  // ==========================================================
		  // BINARY SEARCH EXPERIMENT FOR unique1
		  // ==========================================================

		  public static void binarySearchUnique1() {

		    int low = 1;                     // smallest possible n
		    int high = 150000;               // upper bound guess
		    int best = 0;                    // stores largest valid n

		    // ---- JVM warm-up (important for accurate timing) ----
		    for (int i = 0; i < 3; i++) {     // run a few times
		      int[] warm = new int[10000];    
		      for (int j = 0; j < 10000; j++)
		        warm[j] = j;                  // fill with unique values
		      unique1(warm);                  // run once to warm JIT
		    }

		    // ---- Binary search loop ----
		    while (low <= high) {

		      int mid = low + (high - low) / 2;  // calculate midpoint safely

		      int[] arr = new int[mid];          // create array of size mid
		      for (int i = 0; i < mid; i++)
		        arr[i] = i;                      // fill with unique values (worst case)

		      long start = System.nanoTime();    // record start time
		      unique1(arr);                      // run algorithm
		      long elapsed = (System.nanoTime() - start) / 1_000_000; // convert to ms

		      System.out.printf("unique1 n = %,d : %.3f seconds%n",
		              mid, elapsed / 1000.0);

		      if (elapsed <= 60000) {            // if ≤ 1 minute
		        best = mid;                      // update best valid n
		        low = mid + 1;                   // try larger values
		      } else {
		        high = mid - 1;                  // try smaller values
		      }
		    }

		    System.out.println("Maximum n for unique1: " + best);
		  }


		  // ==========================================================
		  // BINARY SEARCH EXPERIMENT FOR unique2
		  // ==========================================================

		  public static void binarySearchUnique2() {

		    int low = 1;                     
		    int high = 5_000_000;            // much higher since O(n log n)
		    int best = 0;                    

		    // ---- JVM warm-up ----
		    for (int i = 0; i < 3; i++) {
		      int[] warm = new int[10000];
		      for (int j = 0; j < 10000; j++)
		        warm[j] = j;
		      unique2(warm);
		    }

		    while (low <= high) {

		      int mid = low + (high - low) / 2;

		      int[] arr = new int[mid];
		      for (int i = 0; i < mid; i++)
		        arr[i] = i;

		      long start = System.nanoTime();
		      unique2(arr);
		      long elapsed = (System.nanoTime() - start) / 1_000_000;

		      System.out.printf("unique2 n = %,d : %.3f seconds%n",
		              mid, elapsed / 1000.0);

		      if (elapsed <= 60000) {
		        best = mid;
		        low = mid + 1;
		      } else {
		        high = mid - 1;
		      }
		    }

		    System.out.println("Maximum n for unique2: " + best);
		  }


		

		  public static void main(String[] args) {

		    System.out.println("Starting experiment for unique1...");
		    binarySearchUnique1();

		    System.out.println("\nStarting experiment for unique2...");
		    binarySearchUnique2();
		  }

	}


