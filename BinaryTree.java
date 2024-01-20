package Tree;

public class BinaryTree {

	Node root;

	BinaryTree() {
		this.root = null;
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println("Preorder Traversal");
		preorderTraversal(tree.root);
		System.out.println("Inorder Traversal");
		inorderTraversal(tree.root);
		System.out.println("Print Leaf Nodes");
		printLeafNodes(tree.root);
		System.out.println("Count Leaf Nodes");
		int ans = countLeafNodes(tree.root);
		System.out.println(ans);
		System.out.println("Level Order Traversal");
		levelOrderTraversal(tree.root);
		System.out.println("Lowest Common Ancestor");
		int a = 4;
		int b = 2;
		Node root1 = lowestCommonAncestor(tree.root, a, b);
		System.out.println(root1.data);
	}

	private static Node lowestCommonAncestor(Node root, int a, int b) {

		if (root == null) {
			return null;
		}
		if (root.data == a || root.data == b) {
			return root;
		}
		Node left = lowestCommonAncestor(root.left, a, b);
		Node right = lowestCommonAncestor(root.right, a, b);
		if(left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return root;
	}

	private static void levelOrderTraversal(Node root) {

		int h = height(root);
		System.out.println(h);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	private static void printGivenLevel(Node root, int level) {

		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.data);
		}
		if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	private static int height(Node root) {

		if (root == null) {
			return 0;
		}
		int lheight = height(root.left);
		int rheight = height(root.right);
		if (lheight > rheight) {
			return lheight + 1;
		} else {
			return rheight + 1;
		}
	}

	private static int countLeafNodes(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return countLeafNodes(root.left) + countLeafNodes(root.right);

	}

	private static void printLeafNodes(Node root) {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		if (root.left != null) {
			printLeafNodes(root.left);
		}
		if (root.right != null) {
			printLeafNodes(root.right);
		}
	}

	private static void inorderTraversal(Node root) {

		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	}

	private static void preorderTraversal(Node root) {

		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

}
