package interviewdose.tree;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void flatten(TreeNode root) {
		List<TreeNode> traversedNodes = new ArrayList<>();
		if(root!=null) {
			
			traversePreOrder(root,traversedNodes);
			System.out.println(traversedNodes);
			for(int i = 0 ;i<traversedNodes.size()-1;i++) {
				TreeNode node = traversedNodes.get(i);
				node.left = null;
				node.right = traversedNodes.get(i+1);
			}
			
			root.val = traversedNodes.get(0).val;
			root.left = traversedNodes.get(0).left;
			root.right = traversedNodes.get(0).right;
		}
		
		
		
        
    }
	
	
	public void traversePreOrder(TreeNode node,List<TreeNode> traversedNodes) {
		if(node==null) {
			return ;
		}else {
			TreeNode newNode = new TreeNode(node.val);
			traversedNodes.add(newNode);
			traversePreOrder(node.left,traversedNodes);
			
			traversePreOrder(node.right,traversedNodes);
			
			 
		}
		
		
	}

}
