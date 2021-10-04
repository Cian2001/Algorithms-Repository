public class RussianPeasantsAlgorithm {
	public static void main(String[] args) {

		In in = new In(args[0]);// to take input from a file
		int[] a = in.readAllInts();

		long x, y, res = 0; // i changed it to long because ints were too small
		
		x = a[0];//input first two digits in a file
		y = a[1];	
		
		while(x>1){	
			if(x%2 == 1) {// checks if it is an odd number (remainder)
				res += y;// if it is it adds on to the total
			}
			x=x/2;// x is halved until it is less than 1
			y=y*2;// y is doubled until x is less than 1
		}
		res += y;//adds up the results
		
	    Stopwatch timer = new Stopwatch();// records the length of time in ms
	    StdOut.println("elapsed time = " + timer.elapsedTime());
		System.out.println(res);
	}
}




