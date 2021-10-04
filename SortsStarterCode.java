import java.util.Random;

public class SortsStarterCode {
	
private static void shuffle(int[] arr)
{
	for (int i=1; i < arr.length; i++)
	swap(arr, i, (int)(Math.random()*i));
}
	
private static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
}

private static int getSmallestIndex(int[] arr, int lower, int upper) {
	int indexOfMin = lower;
	for (int i = lower+1; i <= upper; i++)
		if (arr[i] < arr[indexOfMin])
			indexOfMin = i;
			return indexOfMin;
}
	
public static int[] selectionSort(int[] arr) {
	for (int i = 0; i < arr.length-1; i++) {
		int j = getSmallestIndex(arr, i, arr.length-1);
		swap(arr, i, j);
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

public static int[] bogoSort(int[] arr)
{
    // if array is not sorted then shuffle the array again
    while (isSorted(arr) == false){
        shuffle(arr);
    }
    return arr;
}

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
public static void main(String[] args) {
	
	Random rand = new Random(); 
    int[] array1 = new int[10]; // change size of array here
    
    // Generates random array
    for (int i = 0; i < array1.length; i++) {
       array1[i] = rand.nextInt(); // storing random integers in an array
    }
	
	//Prints out generated appay
	 System.out.print("Given array: ");
	 for (int element: array1) {
         System.out.print(element + " ");
     }
	 
	 // Stopwatch
	 double startTime, finishTime, timeElapsed;
	 startTime = System.currentTimeMillis();
	 
	 insertionSort(array1);
	 selectionSort(array1);
//	 bogoSort(array1);
	 
	 finishTime = System.currentTimeMillis();
	 timeElapsed = finishTime - startTime;
	 

	 // Prints out array
	 System.out.print("\nSorted Array: ");
	 for (int increment: array1) {
         System.out.print(increment + " ");
     }
	 
  	System.out.println("\nTime elapsed: " + timeElapsed);
	}
}
