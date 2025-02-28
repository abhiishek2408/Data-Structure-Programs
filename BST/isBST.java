// Class representing a node in the binary tree
class Node {
    int key; // Value of the node
    Node left, right; // Pointers to the left and right children

    // Constructor to create a new node
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Class to check if a binary tree is a Binary Search Tree (BST)
public class isBST {
    int prev = Integer.MIN_VALUE; // Variable to store the previous node's value during in-order traversal

    // Method to check if the tree is a BST
    boolean inBST(Node root) {
        // Base case: if the node is null, return true
        if (root == null) return true;

        // Recursively check the left subtree
        if (!inBST(root.left)) return false;

        // Check if the current node's key is greater than the previous node's key
        if (root.key <= prev) return false;

        // Update the previous node's key
        prev = root.key;

        // Recursively check the right subtree
        return inBST(root.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        // Create an instance of isBST
        isBST tree = new isBST();

        // Check if the tree is a BST and print the result
        if (tree.inBST(root)) {
            System.out.println("The tree is a Binary Search Tree.");
        } else {
            System.out.println("The tree is not a Binary Search Tree.");
        }
    }
}
