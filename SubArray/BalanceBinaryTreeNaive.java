
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BalanceBinaryTreeNaive {
    Node root;

    // Function to check if the tree is balanced
    boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        return (Math.abs(lh - rh) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    // Function to calculate the height of the tree
    int height(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        BalanceBinaryTreeNaive tree = new BalanceBinaryTreeNaive();

        // Creating a simple balanced binary tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        if (tree.isBalanced(tree.root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}