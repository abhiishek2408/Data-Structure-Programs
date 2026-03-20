package Tree;

class _CheckBalanceBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    _CheckBalanceBinaryTree() {
        this.root = null;
    }

    // Naive Method (O(n^2))
    boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        return (Math.abs(lh - rh) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    int height(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    
    // Efficient Method Helper (O(n))
    int checkHeight(Node root) {
        if (root == null)
            return 0;

        int lh = checkHeight(root.left);
        if (lh == -1) return -1;

        int rh = checkHeight(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }

    // Wrapper for Efficient Method
    boolean isBalancedEfficient(Node root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        _CheckBalanceBinaryTree tree = new _CheckBalanceBinaryTree();

        // Creating a simple balanced binary tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Using Naive Approach:");
        if (tree.isBalanced(tree.root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");

        System.out.println("Using Efficient Approach:");
        if (tree.isBalancedEfficient(tree.root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}
