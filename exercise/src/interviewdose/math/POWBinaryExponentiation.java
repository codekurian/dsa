package interviewdose.math;

public class POWBinaryExponentiation {

	public static void main(String[] args) {

		System.out.println(1 / pow(2.00000, 2));

	}

	/**
	 * @param x
	 * @param n
	 * @return This algorithm works for x^n(x to the power n) where for even powers
	 *         we halve the power and square the base(multiply the base to itself)
	 *         and for odd powers we store the extra odd power in the result which
	 *         eventually gets multiplied
	 * 
	 */
	static double pow(double x, int n) {
		double result = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				result *= x;
			}
			n = n / 2;
			x = x * x;
		}
		return result;

	}

	/**
	 * @param x
	 * @param n
	 * @return
	 * 
	 * This algorithm works on the principle that if we want to find x^n then 
	 */
	
	static double powUsingBitwiseOperator(double x, int n) {
		double result = 0;
		while (n > 0) {
			// get the least significant bit 
			
			// store it in the result by multiplying it with x if the last bit is 1
			
			//use right shift operator to extract a bit at a time until all bits are right shiften to n
			
		}
		return result;
	}
}
