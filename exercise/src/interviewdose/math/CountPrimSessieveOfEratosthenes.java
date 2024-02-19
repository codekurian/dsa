package interviewdose.math;

import java.lang.reflect.Array;
import java.util.ArrayList;

//https://leetcode.com/problems/count-primes/solutions/
//time complexity nLogLogn -- remember this as taylor series expansion

public class CountPrimSessieveOfEratosthenes {

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		boolean[] seive = new boolean [number];
		
		
		for(int i = 0 ; i<number;i++) {
			seive[i] = true;
		}
		for(int i = 2 ; i<=Math.floor(Math.sqrt(number));i++) {
			
			if(seive[i]) {
				if(isPrimeNumber(i)) {
					//seive[i] = false;
					for(int j=i;i*j<=number;j++)
					seive[i*j] = false;
				}
			}
			
		}
		System.out.println(countTrue(seive));

	}
	static boolean isPrimeNumber(int number) {
		ArrayList<Integer> factorList = new ArrayList<>();
		for (int i = 1; i<=Math.floor(Math.sqrt(number));i++) {
			if (number%i==0) {
				//factor found
				factorList.add(i);
				
			}
			int factorPair = number/i; 
			if(number%factorPair == 0) {
				factorList.add(i);
			}
			if (factorList.size()>2) {
				return false;
			}
		}
		return true;
		
	}
	static int countTrue(boolean primeArray[]) {
	int counter= 0;
	for (int i = 2; i < primeArray.length; i++) {
		if(primeArray[i]==true) {
			counter++;
		}
		
	}
	return counter;
	}

}
