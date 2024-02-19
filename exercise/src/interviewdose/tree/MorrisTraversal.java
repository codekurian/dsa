package interviewdose.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

	public static void main(String[] args) {
		int[] treeArray = new int[] {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		Node rootNode = BinaryTree.buildTree(treeArray);
		//BinaryTree.preorderMorrisTraversal(rootNode);
		BinaryTree.postorderMorrisTraversal(rootNode);

	}
	
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static class BinaryTree {
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
		
		public static void preorderMorrisTraversal(Node rootNode){
			//
			Node currentNode = rootNode;
			while(currentNode!=null) {
				//move to the leftmost node
				if(currentNode.left==null) {
					System.out.println(currentNode.data+" ");
					currentNode = currentNode.right;
				}else {
					//initializing the preorder of the node
					Node preorderOfCurrentNode = currentNode.left;
					while(preorderOfCurrentNode.right!=null && preorderOfCurrentNode.right!=currentNode) {
						preorderOfCurrentNode = preorderOfCurrentNode.right;
						
					}
					if(preorderOfCurrentNode.right == null) {
						System.out.println(currentNode.data+" ");
						preorderOfCurrentNode.right = currentNode;
						currentNode = currentNode.left;
					}else {
						preorderOfCurrentNode.right = null;
						currentNode = currentNode.right;
					}
				}
			}
			 
			
			
		}
		
		
		//write this again
		public static void postorderMorrisTraversal(Node rootNode){
			//
			Node currentNode = rootNode;
			while(currentNode!=null) {
				//move to the leftmost node
				if(currentNode.left==null) {
					System.out.println(currentNode.data+" ");
					currentNode = currentNode.right;
				}else {
					//initializing the preorder of the node
					Node postorderOfCurrentNode = currentNode.left;
					while(postorderOfCurrentNode.right!=null && postorderOfCurrentNode.right!=currentNode) {
						postorderOfCurrentNode = postorderOfCurrentNode.right;
						
					}
					if(postorderOfCurrentNode.right == null) {
						
						postorderOfCurrentNode.right = currentNode;
						currentNode = currentNode.left;
					}else {
						postorderOfCurrentNode.right = null;
						System.out.println(currentNode.data+" ");
						currentNode = currentNode.right;
						
					}
				}
			}
			 
			
			
		} 

}
}