package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import nodes.TreeNode;

public class BinaryTreeInorder94 {
	// 递归
	public List<Integer> inorderTraversal(TreeNode cur, List<Integer> res) {
		if (cur != null) {
			inorderTraversal(cur.left, res);
			res.add(cur.val);
			inorderTraversal(cur.right, res);
		}
		return res;
	}

	// 迭代器
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode cur = root;
		Stack<TreeNode> tempStack = new Stack<>();
		while(cur != null || !tempStack.isEmpty()){
			while (cur != null) {
				//res.add(cur.val);		//preOrder
				tempStack.push(cur);
				cur = cur.left;
			}
			cur = tempStack.pop();
			//res.add(cur.val);		//inOrder
			cur = cur.right;
		}
		
		return res;
	}

	public static void main(String[] args) {
		//tree 1
		TreeNode eNode = new TreeNode(6, null, null);
		TreeNode gNode = new TreeNode(7, null, null);
		TreeNode dNode = new TreeNode(4, null, eNode);
		TreeNode fNode = new TreeNode(5, gNode, null);
		TreeNode cNode = new TreeNode(3, null, null);
		TreeNode bNode = new TreeNode(2, dNode, fNode);
		TreeNode aNode = new TreeNode(1, bNode, cNode);

		//tree 2
		TreeNode c = new TreeNode(3, null, null);
		TreeNode b = new TreeNode(2, c, null);
		TreeNode a = new TreeNode(1, null, b);

		BinaryTreeInorder94 bti94 = new BinaryTreeInorder94();
		List<Integer> temp = new ArrayList<>();
		List<Integer> res = bti94.inorderTraversal(aNode);
		for (Integer integer : res) {
			System.out.println(integer);
		}
	}

}
