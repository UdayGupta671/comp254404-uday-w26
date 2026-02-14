package lab2;
import java.util.Random;
public class prefixExp {
	

	    // Generate random array
	    public static double[] generateArray(int n) {
	        Random rand = new Random();
	        double[] arr = new double[n];
	        for (int i = 0; i < n; i++)
	            arr[i] = rand.nextDouble();
	        return arr;
	    }

	    // Measure prefixAverage1 time (ms)
	    public static long timePrefix1(int n) {
	        double[] arr = generateArray(n);
	        long start = System.nanoTime();
	        PrefixAverage.prefixAverage1(arr);
	        return (System.nanoTime() - start) / 1_000_000;
	    }

	    // Measure prefixAverage2 time (ms)
	    public static long timePrefix2(int n) {
	        double[] arr = generateArray(n);
	        long start = System.nanoTime();
	        PrefixAverage.prefixAverage2(arr);
	        return (System.nanoTime() - start) / 1_000_000;
	    }

	    public static void main(String[] args) {

	        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};

	        System.out.println("n\tprefix1(ms)\tprefix2(ms)");

	        for (int n : sizes) {

	            long t1 = timePrefix1(n);
	            long t2 = timePrefix2(n);

	            System.out.println(n + "\t" + t1 + "\t\t" + t2);
	        }
	    }
	}



