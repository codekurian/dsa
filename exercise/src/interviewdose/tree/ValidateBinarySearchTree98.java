package interviewdose.tree;

//https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchTree98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {
		
		boolean isValidBST = true;
		isValidBST = traverse(root, isValidBST, Long.MIN_VALUE, Long.MAX_VALUE);
		return isValidBST;


	}
	
	public boolean isValidNode(TreeNode node , long minValue,long maxValue) {
		if(node.val>minValue&&node.val<maxValue) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean traverse(TreeNode node,boolean isValidBST,long minValue,long maxValue ) {
		if(node ==  null || !isValidBST) {
			return isValidBST;
		}else {
			 isValidBST = isValidNode(node, minValue, maxValue);
            System.out.println("isValidBST "+isValidBST);
			
			//for the left node the max value has to be smaller than root and the min value smaller than infinity so it remains the same
			
			isValidBST = traverse(node.left,isValidBST,minValue,node.val);
			
			//for the right node min value has to be greater than the root node and max value can be anything but less than infinity.
			isValidBST = traverse(node.right,isValidBST,node.val,maxValue);
		}
		return isValidBST;
	}
	
	
}
