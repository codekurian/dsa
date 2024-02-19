package interviewdose.math;


import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/count-primes/
//O(n(root n))
public class CountPrimes {

	public static void main(String[] args) {
	
		int number = Integer.parseInt(args[0]);
		List<Integer>primeNumbers = new ArrayList<>();
		
		for (int i = 2; i <= number; i++) {
			if(isPrimeNumber(i)) {
				primeNumbers.add(i);
			}
			
		}
		System.out.println(primeNumbers);
		System.out.println(primeNumbers.size());
		
		

	}

	
	
	static boolean isPrimeNumber(int number) {
		ArrayList<Integer> factorList = new ArrayList<>();
		for (int i = 1; i<=Math.sqrt(number);i++) {
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
}
