package interviewdose.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arrayToBeSorted = new int [] {2,0,2,1,1,0};
		quickSort(arrayToBeSorted, 0, arrayToBeSorted.length-1);
		for (int i = 0; i < arrayToBeSorted.length; i++) {
			System.out.println(arrayToBeSorted[i]);
		}
		
         
		//a method that does quicksort 
		
	}
	
	public static void quickSort(int array[] ,int low,int high) {
		//recursive function that does the quicksort
		if(low<high) {
			int pivotIdx = partition(array , low, high);
			//sorting left partition which is less than Pivot
			quickSort(array, low, pivotIdx-1);
			//sorting right partition which is greater than Pivot
			quickSort(array, pivotIdx, high);
		}
		
		
	}

	/**
	 * @param array
	 * @param low
	 * @param high
	 * @param pivot
	 * @return index of the pivot element
	 */
	private static int partition(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int pivot = high;
		//a special variable which is used to increment only when we find a value lesser than the pivot 
		//basically the thought process should be ki khaali jagah banane padhe to increment karo . Khaali jagah banayenge jab pivot se chota element milega .
		//swap will happen with this i variable whenever we find a smaller element than pivot 
		int i = low-1;
		//we need to loop through the entire array and place the pivot in the right place after one sweep
		//so when we place all elements smaller than pivot to the left of pivot so after one complete sweep wherever i is we need to place pivot next to it.
		//So we will make space and place the pivot by swapping 
		
		for (int j = low; j < high; j++) {
			if(array[j]<=array[pivot]) {
				//jagah banate 
				i++;
				swapNumbersinArray(array, i, j);
				
			}
			
		}
		i++;
		//place pivot to i after making space and then retun the index as the Pivot.
		swapNumbersinArray(array, i, pivot);
		return i;
	}
	
	private static int[]  swapNumbersinArray(int[] numbers, int indexOfA, int indexOfB) {
		 int a = numbers[indexOfA];
		 numbers[indexOfA] = numbers[indexOfB] ;
		 numbers[indexOfB]=a;
		 return numbers;
	}
	
	

}
