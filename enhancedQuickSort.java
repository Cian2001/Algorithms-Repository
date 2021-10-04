import java.util.Random;

public class enhancedQuickSort {

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private static void shuffle(int[] arr)
	{
		for (int i=1; i < arr.length; i++)
		swap(arr, i, (int)(Math.random() * i));
	}

	private static int partition (int arr[], int start, int end)
	{
	    int pivot = arr[end], middle = arr[((end - start) / 2) + start]; // pivot
	    
	    if(((arr[end] >= arr[start]) && (arr[end] <= arr[middle]))
	    		|| ((arr[end] <= arr[start]) && (arr[end] >= arr[middle]))){
	    	pivot = arr[end]; //if end is the median, make it the pivot
	    }
	    else if(((arr[middle] >= arr[start]) && (arr[middle] <= arr[end]))
	    		|| ((arr[middle] <= arr[start]) && (arr[middle] >= arr[end]))) {
	    	pivot = arr[middle]; //if middle is the median, make it the pivot	
	    }
	    else {
	    	pivot = arr[start]; //then start must be the median, so make it the pivot
	    }
	    	
	    int pi = start; 
	 
	    for (int i = start; i < end ; i++){
	    	
	        // If current element is smaller than the pivot
	        if (arr[i] <= pivot)
	        {
	            swap(arr,pi,i);// swap pi and i
	        	pi++; // increment index of smaller element
	        }
	    }
	    swap(arr,pi, end);//swap pi and end
	    return pi;
	}
	 
	private static int[] quickSort(int arr[], int start, int end)
	{
		shuffle(arr);
		
	    if(arr.length <= 10) {
	    	insertionSort(arr);
	    }
	    else {
		if (start < end)
	    {
	        int piv = partition(arr, start, end);
	 
	        //divide into two, before and after pivot
	        quickSort(arr, start, piv - 1); //swap the first element with the last before the pivot
	        quickSort(arr, piv + 1, end); // swap the element after the pivot with the last element
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
	
	public static void main(String[] args) {
		
		Random rand = new Random(); 
	    int[] array1 = new int[10]; // change size of array here
	    
	    // Generates random array
	    for (int i = 0; i < array1.length; i++) {
	       array1[i] = rand.nextInt(); // storing random integers in an array
	    }
		 
	    // Stopwatch
		 double startTime, finishTime, timeElapsed;
		 startTime = System.currentTimeMillis();
		 
		 quickSort(array1, 0, array1.length - 1);
		 
		 finishTime = System.currentTimeMillis();
		 timeElapsed = finishTime - startTime;

		 for (int increment: array1) {
	         System.out.print(increment + " ");
	     }
		 
		  	System.out.println("\nTime elapsed: " + timeElapsed);
	}

}
