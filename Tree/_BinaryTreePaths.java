package Tree;

import java.util.*;

public class _BinaryTreePaths {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            this.data = value;
            left = right = null;
        }
    }

    Node root;

    _BinaryTreePaths() {
        root = null;
    }

    // Recursive function to collect all root-to-leaf paths
    void printAllPaths(Node root) {
        List<Integer> currentPath = new ArrayList<>();
        printPathsHelper(root, currentPath);
    }

    private void printPathsHelper(Node root, List<Integer> path) {
        if (root == null)
            return;

        // Add current node to the path
        path.add(root.data);

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            // Recur for left and right children
            printPathsHelper(root.left, new ArrayList<>(path));
            printPathsHelper(root.right, new ArrayList<>(path));
        }
    }

    public static void main(String[] args) {
        _BinaryTreePaths tree = new _BinaryTreePaths();

        // Sample binary tree:
        //         1
        //       /   \
        //     2       3
        //   /   \       \
        //  4     5       6
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        System.out.println("All Root-to-Leaf Paths:");
        tree.printAllPaths(tree.root);
    }
}
