package interviewdose.math;

//O(log(min(a,b))) -- if a is minimum a compressos first as a log function 

public class GCDEuclidean {

	public static void main(String args []) {
		
		System.out.println(getGCD(10, 16));
		
	}

	static int getGCD(int a, int b) {
		if(a==0) {
			return b;
		}else {
			return getGCD(b%a, a);
		}
		
		
	}
}


