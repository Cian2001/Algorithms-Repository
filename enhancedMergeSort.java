import java.util.Random;

class enhancedMergeSort
{
	// To check if array is sorted or not
	static boolean isSorted(int[] arr)
	{
	    for (int i=1; i<arr.length; i++) {
	        if (arr[i] <= arr[i-1]){
	            return false;
	        }
	    }
	    return true;
	}
	
	// if array is sorted it avoids the recursive process
	static int[] preSort(int arr[], int l, int r)
    {
		if(!(isSorted(arr))) {
			sort(arr, 0, arr.length - 1);
		}  
	  return arr;
    }
	
	
   static int[] merge(int arr[], int start, int middle, int end)
    {
        // Find sizes of two sub-arrays to be merged
        int size_left = middle - start + 1;
        int size_right = end - middle;
 
        /* Create temp arrays */
        int LeftSub[] = new int[size_left];
        int RightSub[] = new int[size_right];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < size_left; ++i)
        	LeftSub[i] = arr[start + i];
        for (int j = 0; j < size_right; ++j)
        	RightSub[j] = arr[middle + 1 + j];

        
//Merging the two arrays... 
        // Resetting the indexes of the two arrays
        int i = 0, j = 0;
 
        // Initial index of merged sub-array
        int k = start;
        while (i < size_left && j < size_right) {
            if (LeftSub[i] <= RightSub[j]) {
                arr[k] = LeftSub[i];
                i++;
            }
            else {
                arr[k] = RightSub[j];
                j++;
            }
            k++;
        }
 
        //If there are any elements left in one array and none in the other, put them in 
        while (i < size_left) {
            arr[k] = LeftSub[i];
            i++;
            k++;
        }
        while (j < size_right) {
            arr[k] = RightSub[j];
            j++;
            k++;
        }
        return arr;
    }
 
    static int[] sort(int arr[], int l, int r)
    {
    	if(arr.length <= 10) {
	    	insertionSort(arr);
	    }
	    else {
    	if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
        return arr;
    }
    
	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
				if (arr[i] < arr[i-1]) {
					int toInsert = arr[i];
					int j = i;
				
				do {
					arr[j] = arr[j-1];
					j = j - 1;
				} while (j > 0 && toInsert < arr[j-1]);
				
				arr[j] = toInsert;
			}
		}
		return arr;
	}
    // Driver code
    public static void main(String args[])
    {
		Random rand = new Random(); 
	    int[] array1 = new int[100000]; // change size of array here
	    
	    // Generates random array
	    for (int i = 0; i < array1.length; i++) {
	       array1[i] = rand.nextInt(); // storing random integers in an array
	    }
		 
	    // Stopwatch
		double startTime, finishTime, timeElapsed;
		startTime = System.currentTimeMillis();
		 
	        preSort(array1, 0, array1.length - 1);
		 
		finishTime = System.currentTimeMillis();
		timeElapsed = finishTime - startTime;

		for (int increment: array1) {
	         System.out.print(increment + " ");
	    }
		 
		  	System.out.println("\nTime elapsed: " + timeElapsed);
    }
}