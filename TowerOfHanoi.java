
public class TowerOfHanoi {

	static void towerOfHanoi(int n, char source, char aux, char dest) {
	      if (n == 1) {
	          System.out.println("Disk 1 from " + source + " to " + dest);
	       } else {
	    	   towerOfHanoi(n - 1, source, dest, aux);
	          System.out.println("Disk " + n + " from " + source + " to " + dest);
	          towerOfHanoi(n - 1, aux, source, dest);
	       }
	} 
	
	public static void  main(String args[]) { 
	    int n = 6; // Number of disks 
	    towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods 
	} 
}
