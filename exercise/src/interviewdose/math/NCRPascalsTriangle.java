package interviewdose.math;

public class NCRPascalsTriangle {

	public static void main(String[] args) {
		
		int rows = 5;
		int columns = 5;
		int[][] pascalsTriangle = preProcessPascalsTriangle(rows, columns);
        //4C2 = 6 
		int result = pascalsTriangle[4][2];
		System.out.println(result);
	}

	/**
	 * @param rows
	 * @param columns
	 * @return
	 * time complexity is rows * columns == O(N*R)
	 */
	static int[][] preProcessPascalsTriangle(int rows,int columns){
		int[][] pascalsTriangle = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				//diagonal is i==j and j==0 is the first columns and in Pascals triangle both are 1
				if(i==j || j==0)
				{
					pascalsTriangle[i][j]=1;
				}else {
					pascalsTriangle[i][j]=pascalsTriangle[i-1][j-1]+pascalsTriangle[i-1][j];
				}
				
			}
			
		}
		
		return pascalsTriangle;
	}
}
