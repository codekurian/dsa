package interviewdose.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree297 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder serializedString = new StringBuilder();
		queue.offer(root);

		if (null != root) {

			serializedString.append(root.val);

			serializedString.append(",");
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();

					if (null != node.left) {
						serializedString.append(node.left.val);
						queue.offer(node.left);
						serializedString.append(",");
					} else {
						serializedString.append("NULL");
						serializedString.append(",");
					}
					if (null != node.right) {
						serializedString.append(node.right.val);
						queue.offer(node.right);
						serializedString.append(",");
					} else {
						serializedString.append("NULL");
						serializedString.append(",");
					}
				}

			}
			serializedString.deleteCharAt(serializedString.lastIndexOf(","));
			System.out.println(serializedString.toString());
		}
		return serializedString.toString();

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] levelOrderArray = data.split(",");
		TreeNode rootNode = null;
		// Queue<String> queue = new LinkedList<String>();
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		if (levelOrderArray.length > 0) {
			if (!levelOrderArray[0].equals("NULL") && !levelOrderArray[0].equals("")) {
				System.out.println(levelOrderArray[0].trim());
				int nodeInt = Integer.parseInt(levelOrderArray[0].trim());
				rootNode = new TreeNode(nodeInt);
				nodeQueue.offer(rootNode);
			}

		}

		// while (!nodeQueue.isEmpty()) {

		for (int i = 1; i < levelOrderArray.length - 2; i = i + 2) {
			TreeNode node = nodeQueue.poll();
			if (!levelOrderArray[i].equals("NULL")) {

				int nodeLeft = Integer.parseInt(levelOrderArray[i]);
				TreeNode leftNode = new TreeNode(nodeLeft);
				node.left = leftNode;
				nodeQueue.offer(leftNode);

			}
			if (!levelOrderArray[i + 1].equals("NULL")) {
				int nodeRight = Integer.parseInt(levelOrderArray[i + 1]);
				TreeNode rightNode = new TreeNode(nodeRight);
				node.right = rightNode;
				nodeQueue.offer(rightNode);
			}

		}

		// }
		return rootNode;

	}
}
