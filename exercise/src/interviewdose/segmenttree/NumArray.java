package interviewdose.segmenttree;
//https://leetcode.com/problems/range-sum-query-mutable/description/
public class NumArray {
	int [] segmentTree ;
	int arrayLength ;
	int[] numsArray ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumArray nums = new NumArray(new int[]{0,9,5,7,3}) ;
		int sum = nums.sumRange(2, 4);
		System.out.println("Sum ::" +sum);
		
		

	}
	
	//

    public NumArray(int[] nums) {
    	segmentTree = new int[4*(nums.length)+1];
    	arrayLength = nums.length;
    	numsArray = nums;
    	buildSegmentTree(nums, segmentTree, 1, 0, arrayLength-1);
    	System.out.println(segmentTree);
    }
    
    public void update(int index, int val) {
        int difference = numsArray[index] - val;
        numsArray[index] = val;
        updateSegmentTree(segmentTree, 1, 0, arrayLength-1, difference, index);
        
    }
    
    public int sumRange(int left, int right) {
		
    	return findSumSegmentTree(segmentTree, left, right, 1, 0, arrayLength-1);
    	
  
        
    }
    public void buildSegmentTree (int[] nums,int [] segmentTree,int si,int start,int end) {
    	 
    	if(start>end) {
    		return;
    	}
    	
    	if(start == end) {
    		segmentTree[si]= nums[start];
    		 return;
    	 }else {
    		 int mid = start + (end-start)/2;
    		 buildSegmentTree(nums, segmentTree, 2*si, start, mid);
    		 buildSegmentTree(nums, segmentTree, 2*si+1, mid+1, end);
    		 segmentTree[si]=segmentTree[2*si]+segmentTree[2*si+1];
    		 
    	 }
    }
    
    public int findSumSegmentTree (int [] segmentTree,int qsIndx,int qeIndx,int si,int start,int end) {
   	    int sum = 0 ;
    	if(start>end) {
    		return sum;
    	}
    	//Case 1 when there is no overlap - >  return 0 we need not consider for calculation;
    	if(qeIndx<start || qsIndx >end) {
    		return 0 ;
    	}
    	
    	//Case 2 : when there is complete overlap -- > return the value 
    	if(qsIndx<=start && qeIndx>=end) {
    		return segmentTree[si];
    	}else {
    		//Case 3 : when there is partial overlap -- > some work so we will further do some work and consider the value in the sum 
    		int mid = start + (end-start)/2;
    		int ls = findSumSegmentTree(segmentTree, qsIndx, qeIndx, 2*si, start, mid);
    		int rs = findSumSegmentTree(segmentTree, qsIndx, qeIndx, 2*si+1, mid+1, end);
    		return ls+rs;
    	}
    	
    }
    
    public void updateSegmentTree (int [] segmentTree,int si,int sl,int sr,int difference,int pos) {
    	if(pos<sl || pos>sr ) {
    		return;
    	}
    	segmentTree[si]+=difference;
    	if(sl!=sr) {
    		int mid = sl + (sr-sl)/2;
    		updateSegmentTree(segmentTree, 2*si, sl, mid, difference, pos);
    		updateSegmentTree(segmentTree, 2*si+1, mid+1, sr, difference, pos);
    		segmentTree[si]=segmentTree[2*si]+segmentTree[2*si+1];
    	}
    	
    }
}
