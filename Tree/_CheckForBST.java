package Tree;

public class _CheckForBST {

    static class Node {
        int data; 
        Node left, right; 
    
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Utility function with min and max range
    boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true;

        // Violation of BST property
        if (node.data <= min || node.data >= max) return false;

        // Recur for left and right subtrees
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        // Create an instance of isBST
        _CheckForBST tree = new _CheckForBST();

        // Check if the tree is a BST and print the result
        if (tree.isBST(root)) {
            System.out.println("The tree is a Binary Search Tree.");
        } else {
            System.out.println("The tree is not a Binary Search Tree.");
        }
    }
}
