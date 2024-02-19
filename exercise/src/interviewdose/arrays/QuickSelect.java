package interviewdose.arrays;

import java.util.Random;

public class QuickSelect {

	public static void main(String[] args) {
		
		int[] arrayToBeSorted = new int [] {-1,-2,-3,-4,-5,-6};
		
		int index= 2;
		int indexToBeSearched = arrayToBeSorted.length-index;
		quickSelectKthLargest(arrayToBeSorted,indexToBeSearched, 0, arrayToBeSorted.length-1);
		System.out.println(index+ "th largest element" + arrayToBeSorted[indexToBeSearched]);
		for (int i = 0; i < arrayToBeSorted.length; i++) {
			System.out.println(arrayToBeSorted[i]);
		}

	}

	private static void quickSelectKthLargest(int[] arrayToBeSortedAndSearched,int k, int lowIndex, int highIndex) {
		// Similar to quick sort except that whenever we find that the number is less or greater than pivot we need not process the other half
		
		if(lowIndex < highIndex) {
			 int pivotIndex = partition(arrayToBeSortedAndSearched,lowIndex,highIndex);
			 quickSelectKthLargest(arrayToBeSortedAndSearched, k, lowIndex, pivotIndex-1);
			 quickSelectKthLargest(arrayToBeSortedAndSearched, k, pivotIndex+1, highIndex);
			/*
			 if(pivotIndex==k) {
				return ;
			}if(k<pivotIndex) {
				quickSelectKthLargest(arrayToBeSortedAndSearched, k, lowIndex, pivotIndex-1);
			}else if(k>pivotIndex) {
				quickSelectKthLargest(arrayToBeSortedAndSearched, k, pivotIndex+1, highIndex);
			}
			
			*/

		}
	
			}

	
	static void random(int arr[],int low,int high) 
    { 
     
        Random rand= new Random(); 
        int pivot = rand.nextInt(high-low)+low; 
         
        int temp1=arr[pivot];  
        arr[pivot]=arr[high]; 
        arr[high]=temp1; 
    } 
	private static int partition(int[] arrayToBeSortedAndSearched, int lowIndex, int highIndex) {
		random(arrayToBeSortedAndSearched, lowIndex, highIndex);
		int i = lowIndex-1;
		int pivot = highIndex;
		
		if(lowIndex<highIndex) {
			
			
			for (int j = lowIndex; j < pivot; j++) {
				if(arrayToBeSortedAndSearched[j]<arrayToBeSortedAndSearched[pivot]) {
					i++;
					swapNumbersinArray(arrayToBeSortedAndSearched, i, j);
				}
				
			}
		}
		i++;
		swapNumbersinArray(arrayToBeSortedAndSearched, i, pivot);
		return i;
	}
	
	
	private static int[]  swapNumbersinArray(int[] numbers, int indexOfA, int indexOfB) {
		 int a = numbers[indexOfA];
		 numbers[indexOfA] = numbers[indexOfB] ;
		 numbers[indexOfB]=a;
		 return numbers;
	}

}
