import java.util.Random;

public class QuickSort {

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	

	private static int partition (int arr[], int start, int end)
	{
	    int pivot = arr[end]; // pivot
	    int pi = start, i; 
	 
	    for (i = start; i <= end - 1; i++){
	    	
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
	    if (start < end)
	    {
	        int piv = partition(arr, start, end);
	 
	        //divide into two, before and after pivot
	        quickSort(arr, start, piv - 1); //swap the first element with the last before the pivot
	        quickSort(arr, piv + 1, end); // swap the elemant after the pivot with the last element
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
