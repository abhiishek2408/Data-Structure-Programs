

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BalanceBinaryTreeEfficient {
    Node root;

    // Function to check if the tree is balanced
    int isBalanced(Node root) {
        if (root == null)
            return 0;

        int lh = isBalanced(root.left);
        if (lh == -1)
            return -1;

        int rh = isBalanced(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }

    // Wrapper function to return boolean result
    boolean isBalancedTree(Node root) {
        return isBalanced(root) != -1;
    }

    public static void main(String[] args) {
        BalanceBinaryTreeEfficient tree = new BalanceBinaryTreeEfficient();

        // Creating a simple balanced binary tree
        tree.root = new Node(8);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(10);
        tree.root.left.right = new Node(14);
        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(20);

        if (tree.isBalancedTree(tree.root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}