package interviewdose.tree;
//https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
public class CountGoodNodesInBinaryTree1448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int goodNodes(TreeNode root) {
        int goodNodesCount = 0 ;
        traverse(root, Long.MIN_VALUE, goodNodesCount);
        return goodNodesCount;
    }
	
	public int traverse(TreeNode node , long previousMax, int goodNodesCount) {
		 
		 if(node == null ) {
			 return goodNodesCount;
		 }else {
			 
			 if(node.val>=previousMax) {
				 
				 goodNodesCount++;
				 System.out.println("goodNodesCount" +goodNodesCount);
			 }
			 previousMax = Math.max(previousMax, node.val);
			 goodNodesCount = traverse(node.left, previousMax, goodNodesCount);
			 goodNodesCount = traverse(node.right, previousMax, goodNodesCount);
		 }
		 return goodNodesCount;
	}
}
