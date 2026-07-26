package Tree;

public class _08_CheckBalanceBinaryTree {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    Node root;

    _08_CheckBalanceBinaryTree() {
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
        _08_CheckBalanceBinaryTree solution = new _08_CheckBalanceBinaryTree();

        // Creating a simple balanced binary tree
        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        solution.root.right.left = new Node(6);
        solution.root.right.right = new Node(7);

        System.out.println("Using Naive Approach:");
        if (solution.isBalanced(solution.root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");

        System.out.println("Using Efficient Approach:");
        if (solution.isBalancedEfficient(solution.root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}
