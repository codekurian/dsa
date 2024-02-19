package interviewdose.tree;

//https://leetcode.com/problems/invert-binary-tree/description/
public class InvertBinaryTree226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public TreeNode invertTree(TreeNode root) {
		traverse(root);
		return root;
	        
	    }
	 
	 public void traverse(TreeNode node) {
		 if(node == null) {
			 return;
		 }else {
			 TreeNode left = node.left;
			 node.left = node.right;
			 node.right = left;
			 traverse(node.right);
			 traverse(node.left);
		 }
	 }
}
