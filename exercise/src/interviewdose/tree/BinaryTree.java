package interviewdose.tree;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {
	static int indx = -1;
	

	public static Node buildTree(int[] nodes) {
		indx++;
		

		if (nodes[indx] == -1) {
			return null;
		}
		Node node = new Node(nodes[indx]);
		node.left = buildTree(nodes);
		node.right= buildTree(nodes);

		return node;

	}
	
	public static void preorderTraversal(Node node) {
		  if(node == null ) {
			  return ;
		  }
			System.out.println(node.data+" ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		
	}
	
	public static void postorderTraversal(Node node) {
		if(node == null) {
			return ;
		}
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.data);
		
	}
	public static void main(String args[]) {
		int[] treeArray = new int[] {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		Node rootNode = BinaryTree.buildTree(treeArray);
		//System.out.println(rootNode.data);
		//preorderTraversal(rootNode);
		postorderTraversal(rootNode);
	}
}
