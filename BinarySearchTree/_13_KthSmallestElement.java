package BinarySearchTree;
import java.util.*;

public class _13_KthSmallestElement {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;
    int count = 0;

    // Naive recursive function to find the k-th smallest element
    void printKthRecursive(Node node, int k) {
        if (node != null) {
            printKthRecursive(node.left, k);
            count++;
            if (count == k) {
                System.out.println("Naive Approach: " + node.key);
                return;
            }
            printKthRecursive(node.right, k);
        }
    }

    // Efficient iterative function to find the k-th smallest element
    int kthSmallestIterative(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;

            if (count == k) {
                return current.key;
            }

            current = current.right;
        }

        return -1; // Return -1 if k is out of bounds
    }

    public static void main(String[] args) {
        _13_KthSmallestElement tree = new _13_KthSmallestElement();
        
        // Create the tree as shown in the image
        tree.root = new Node(50);
        tree.root.left = new Node(20);
        tree.root.right = new Node(60);
        tree.root.left.left = new Node(10);
        tree.root.left.right = new Node(40);

        int k = 3;

        // Naive recursive approach
        tree.printKthRecursive(tree.root, k);

        // Efficient iterative approach
        int result = tree.kthSmallestIterative(tree.root, k);
        if (result != -1) {
            System.out.println("Efficient Approach: " + result);
        } else {
            System.out.println("The tree does not have " + k + " elements.");
        }
    }
}