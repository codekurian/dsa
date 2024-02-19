package interviewdose.tree;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class BSTFromPreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        
        if(preorder.length == 0 ) {
        	return root;
        }
        if(preorder.length == 1) {
        	root = new TreeNode(preorder[0]) ;
        }else {
        	
        }
        
        return root;
    }

public int traverseAndCreateNode(TreeNode currentNode , int pos,int[] preorder,int left,int right) {
	int nodeVal = preorder[pos];
	if(null == currentNode) {
		TreeNode rootNode = new TreeNode(nodeVal);
		currentNode = rootNode;
		pos++;
		return pos;
	}
	if(nodeVal<currentNode.val) {
		currentNode.left = new TreeNode(nodeVal);
		
		
	}else {
		currentNode.right = new TreeNode(nodeVal);
		
	
	}
	
	//new node less than node value add to the left child 
	
	//new node greater than node value add to the right child
	
	pos++;
	return pos;
}
}
