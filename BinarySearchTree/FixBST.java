

// Class representing a node in the binary tree

import Tree.Node;

class Node {
    int key; // Value of the node
    Node left, right; // Pointers to the left and right children

    // Constructor to create a new node
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Class to fix a Binary Search Tree (BST) where two nodes are swapped
class FixBST {
    Node prev = null, first = null, second = null; // Variables to track nodes during traversal

    // Method to fix the BST
    void fixBST(Node root) {
        if (root == null) return; // Base case: if the node is null, return

        // Recursively traverse the left subtree
        fixBST(root.left);

        // Check if the current node is out of order
        if (prev != null && root.key < prev.key) { //voilation occur
            // If this is the first occurrence, mark the nodes
            if (first == null) {
                first = prev;
            }
            // Mark the second node
            second = root;
        }

        // Update the previous node
        prev = root;

        // Recursively traverse the right subtree
        fixBST(root.right);
    }

    // Method to swap the values of the two nodes
    void swap() {
        if (first != null && second != null) {
            int temp = first.key;
            first.key = second.key;
            second.key = temp;
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree with swapped nodes
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8); // Swapped node
        root.left.left = new Node(3);
        root.left.right = new Node(20); // Swapped node

        // Create an instance of FixBST
        FixBST tree = new FixBST();

        // Fix the BST
        tree.fixBST(root);
        tree.swap();

        // Print the fixed tree (in-order traversal)
        printInOrder(root);
    }

    // Helper method to print the tree in-order
    static void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }
}
