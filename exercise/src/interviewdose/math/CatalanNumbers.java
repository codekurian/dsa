package interviewdose.math;

public class CatalanNumbers {
public static void main(String args[]) {
	System.out.println(catalanNumberUsingDP(3));
}
/**
 * @param n
 * @return
 * finding nth catalan number using DP -O(n2)
 */
static  int catalanNumberUsingDP(int n) {
	int[] c = new int[n+1];
	if(n>=0) {
		c[0]=1;
		
	}if(n>=1) {
		
		c[1]=1;
	}
	
	for (int i = 2; i <= n; i++) {
		c[i]=0;
		for (int j = 0; j < i; j++) {
			//i-j-1 is used for i=2 and j=0 it is c[0]*c[1] + c[1]*c[0]  
			
			c[i] += c[j]*c[i-j-1]; 
			
		}
		
		
	}
	return c[n];
}

/**
 * @param n
 * @return
 * using Ncr = Ncn-r
 */
static int getCatalanNumberUsingBinomialCoefficient(int n) {
	return 1;
}
}


