package interviewdose.tree;

import java.util.Arrays;
import java.util.stream.IntStream;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class TreeFromInandPreorderTraversal105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode node = traverseAndBuildTree(preorder, inorder);
		return node;

	}

	public TreeNode traverseAndBuildTree(int[] preorder, int[] inorder) {

		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		} else {
			TreeNode rootNode = new TreeNode(preorder[0]);

			// from left of the rootnode in inorder traversal will be the left subtree and
			// right will be the right subtree
			System.out.println("preorder[0] " + preorder[0]);
			int partitionIndex = intStream(inorder, preorder[0]);
			System.out.println("partitionIndex " + partitionIndex);

			int[] leftInorderArray = Arrays.copyOfRange(inorder, 0, partitionIndex);
			System.out.println("leftInorderArray.length " + leftInorderArray);
			int[] leftPreorderArray = Arrays.copyOfRange(preorder, 1, partitionIndex + 1);

			int[] rightInorderArray = Arrays.copyOfRange(inorder, partitionIndex + 1, inorder.length);
			int[] rightPreorderArray = Arrays.copyOfRange(preorder, partitionIndex + 1, preorder.length);
			TreeNode leftNode = traverseAndBuildTree(leftPreorderArray, leftInorderArray);
			TreeNode rightNode = traverseAndBuildTree(rightPreorderArray, rightInorderArray);
			rootNode.left = leftNode;
			rootNode.right = rightNode;
			return rootNode;

		}

	}

	static int intStream(int[] numbers, int target) {
		return IntStream.range(0, numbers.length).filter(i -> numbers[i] == target).findFirst().orElse(-1);
	}

}
