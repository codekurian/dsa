package interviewdose.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author openf
 * O(root N) + log n -- 
 * outer loop runs root n times but the inner loop is compressing N/i ---> 1/2,1/3,1/4 so it is log n series 
 * but it will not always run so it is a sum of both
 *
 */
public class PrimeFactors {

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		System.out.println(findAllPrimeFactors(number));

	}

	public static List<Integer> findAllPrimeFactors(int number){
		// prime factors of 34 is 2 and 17 
		List<Integer> primeFactors = new ArrayList<Integer>();
		for (int i = 2; i <= Math.sqrt(number); i++) {
			while(number%i == 0 ) {
				//i divides number so it is a factor
				number = number/i;
				primeFactors.add(i);
				
			}
			if(number>1) {
				primeFactors.add(number);
				number = number/i;
				//findAllPrimeFactors(number);
			}
			
		}
		return primeFactors;
		
	}
}
