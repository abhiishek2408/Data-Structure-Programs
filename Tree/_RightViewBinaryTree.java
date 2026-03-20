package Tree;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

public class _RightViewBinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    _RightViewBinaryTree() {
        this.root = null;
    }

    // Method 1: Print Right View directly
    void printRightView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // Last node of this level
                if (i == levelSize - 1) {
                    System.out.print(current.data + " ");
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    // Method 2: Return Right View as List
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // Last node in current level = rightmost
                if (i == levelSize - 1) {
                    result.add(current.data);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _RightViewBinaryTree binaryTree = new _RightViewBinaryTree();

        // Constructing the tree
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        binaryTree.root.left.left = new Node(40);
        binaryTree.root.left.right = new Node(50);
        binaryTree.root.left.left.left = new Node(60);

        // Method 1: Print Right View
        System.out.print("Right View (print method): ");
        binaryTree.printRightView(binaryTree.root);

        // Method 2: Get Right View as List
        List<Integer> rightViewList = binaryTree.rightSideView(binaryTree.root);
        System.out.println("\nRight View (List method): " + rightViewList);
    }
}
