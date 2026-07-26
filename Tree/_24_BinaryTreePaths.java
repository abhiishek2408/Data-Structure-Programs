package Tree;

import java.util.*;

public class _24_BinaryTreePaths {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    Node root;

    _24_BinaryTreePaths() {
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

        path.add(root.val);

        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            printPathsHelper(root.left, new ArrayList<>(path));
            printPathsHelper(root.right, new ArrayList<>(path));
        }
    }

    public static void main(String[] args) {
        _24_BinaryTreePaths solution = new _24_BinaryTreePaths();

        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        solution.root.right.right = new Node(6);

        System.out.println("All Root-to-Leaf Paths:");
        solution.printAllPaths(solution.root);
    }
}
