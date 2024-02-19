package interviewdose.tree;
//https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfABinaryTree543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public int diameterOfBinaryTree(TreeNode root) {
	int maxHeight = 0;
	
	return dfsTraverse(root,maxHeight);
        
    }

public int dfsTraverse(TreeNode node,int maxHeight) {
	
	//traverse
	if(node == null) {
		return -1;
	}
	//calculate the diameter at the node
	int leftHeight =  dfsTraverse(node.left,maxHeight) ;
	int rightHeight = dfsTraverse(node.right,maxHeight);
	int max = Math.max(leftHeight, rightHeight);
	int currentHeight = 1+ max;
	System.out.println();
	return  Math.max(currentHeight,maxHeight);
	
	 
}
}
