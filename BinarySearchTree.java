package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinarySearchTree {

	TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public static void main(String[] args) {

		TreeNode rootNode = createBinarySearchTree();
		System.out.println(rootNode.data);
		System.out.println(rootNode.left.right.data);
		TreeNode node55 = new TreeNode(55);
		boolean result = search(rootNode, node55);
		System.out.println(result);

		TreeNode node8 = new TreeNode(8);
		boolean result1 = search(rootNode, node8);
		System.out.println(result1);

		TreeNode maxNode = maximumNode(rootNode);
		System.out.println(maxNode.data);

		TreeNode minNode = minimumNode(rootNode);
		System.out.println(minNode.data);

		System.out.println("Diagonal order Traversal");
		diagonalOrderTraversal(rootNode);

		System.out.println("Diagonal order Traversal");
		diagonalOrderTraversal1(rootNode);

		System.out.println("Spiral order Traversal");
		spiralOrderTraversal(rootNode);
		
		System.out.println("Right Side view");
		List<Integer> ans = rightSideView(rootNode);
		System.out.println(ans);
		
		System.out.println("Left Side view");
		List<Integer> ans1 = leftSideView(rootNode);
		System.out.println(ans1);
		
		System.out.println("Top View");
		topView(rootNode);
		
		System.out.println("Bottom View");
		bottomView(rootNode);
		
		System.out.println("Vertical Order Traversal");
		verticalOrder(rootNode);

	}

	private static void verticalOrder(TreeNode root) {

		Map<Integer, List<Integer>> map = new TreeMap<>();
		int hd = root.height;
		
		verticalOrderTraversal(root,map,hd);
		System.out.println(map.values());
		for(Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
			System.out.println(m.getKey() + " "+ m.getValue());
		}
	}

	private static void verticalOrderTraversal(TreeNode root, Map<Integer, List<Integer>> map, int hd) {

		if(root == null) {
			return;
		}
		if(map.get(hd) == null) {
			List<Integer> list = new ArrayList<>();
			list.add(root.data);
			map.put(hd, list);
		}
		else {
			List<Integer> list = map.get(hd);
			list.add(root.data);
			map.put(hd, list);
		}
		verticalOrderTraversal(root.left, map, hd-1);
		verticalOrderTraversal(root.right, map, hd+1);
	}

	private static void bottomView(TreeNode root) {

		if(root == null) {
			return;
		}
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode current  = queue.remove();
			int hd = current.height;
			
			map.put(hd, current.data);
			if(current.left != null) {
				current.left.height = hd -1;
				queue.add(current.left);
			}
			if(current.right != null) {
				current.right.height = hd +1;
				queue.add(current.right);
			}
		}
		System.out.println(map.values());
	}

	private static void topView(TreeNode root) {

		if(root == null) {
			return;
		}
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode current = queue.remove();
			int hd = current.height;
			if(map.get(hd) == null) {
				map.put(hd, current.data);
			}
			if(current.left != null) {
				current.left.height = hd - 1;
				queue.add(current.left);
			}
			if(current.right != null) {
				current.right.height = hd + 1;
				queue.add(current.right);
			}
		}
		System.out.println(map.values());
		for(Map.Entry<Integer, Integer> m : map.entrySet()) {

			System.out.println(m.getKey()+ " " + m.getValue());
		}
	}

	private static List<Integer> rightSideView(TreeNode root) {

		List<Integer> visibleValues = new ArrayList<>();
		if (root == null) {
			return visibleValues;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0 ; i< size ; i++) {
				TreeNode current = queue.remove();
				if(i == size-1) {
					visibleValues.add(current.data);
				}
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
			}
		}
		return visibleValues;
	}

	private static void diagonalOrderTraversal(TreeNode root) {

		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode current = root;
		while(!queue.isEmpty() || current != null) {
			if(current != null) {
				System.out.println(current.data);
				if(current.left != null) {
					queue.add(current.left);
				}
				current = current.right;
			}else {
				current = queue.remove();
			}
		}
	}

	private static void spiralOrderTraversal(TreeNode root) {

		if (root == null) {
			return;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while ((!s1.isEmpty()) || (!s2.isEmpty())) {
			while (!s1.isEmpty()) {
				TreeNode current = s1.pop();
				System.out.println(current.data);
				if (current.right != null) {
					s2.push(current.right);
				}
				if (current.left != null) {
					s2.push(current.left);
				}
			}
			while (!s2.isEmpty()) {
				TreeNode current = s2.pop();
				System.out.println(current.data);
				if (current.left != null) {
					s1.push(current.left);
				}
				if (current.right != null) {
					s1.push(current.right);
				}
			}
		}
	}

	private static void diagonalOrderTraversal1(TreeNode root) {

		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode current = root;
		while (!queue.isEmpty() || current != null) {
			if (current != null) {
				System.out.println(current.data);
				if (current.right != null) {
					queue.add(current.right);
				}
				current = current.left;
			} else {
				current = queue.remove();
			}
		}
	}

	private static TreeNode minimumNode(TreeNode root) {

		if (root.left == null) {
			return root;
		} else {
			return minimumNode(root.left);
		}
	}

	private static TreeNode maximumNode(TreeNode root) {

		if (root.right == null) {
			return root;
		} else {
			return maximumNode(root.right);
		}
	}

	private static boolean search(TreeNode root, TreeNode node55) {

		if (root == null) {
			return false;
		}
		if (root.data == node55.data) {
			return true;
		}
		boolean result = false;
		if (root.data > node55.data) {
			result = search(root.left, node55);
		} else {
			result = search(root.right, node55);
		}
		return result;

	}

	private static TreeNode createBinarySearchTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node5 = new TreeNode(5);
		TreeNode node55 = new TreeNode(55);

		insert(null, rootNode);
		insert(rootNode, node20);
		insert(rootNode, node10);
		insert(rootNode, node30);
		insert(rootNode, node60);
		insert(rootNode, node50);
		insert(rootNode, node70);
		insert(rootNode, node5);
		insert(rootNode, node55);
		return rootNode;
	}

	private static TreeNode insert(TreeNode root, TreeNode nodeToBeInserted) {
		if (root == null) {
			root = nodeToBeInserted;
			return root;
		}
		if (root.data > nodeToBeInserted.data) {
			if (root.left == null) {
				root.left = nodeToBeInserted;
			} else {
				insert(root.left, nodeToBeInserted);
			}
		}
		if (root.data < nodeToBeInserted.data) {
			if (root.right == null) {
				root.right = nodeToBeInserted;
			} else {
				insert(root.right, nodeToBeInserted);
			}
		}
		return root;
	}
	
	private static List<Integer> leftSideView(TreeNode root) {

		List<Integer> visibleValues = new ArrayList<>();
		if(root == null) {
			return visibleValues;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i< size; i++) {
				TreeNode current = queue.remove();
				if(i == 0) {
					visibleValues.add(current.data);
				}
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
			}
		}
		return visibleValues;
	}
}
