package Tree;

import java.util.*;

public class _16_RightViewBinaryTree {
    Node root;

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    _16_RightViewBinaryTree() {
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

                if (i == levelSize - 1) {
                    System.out.print(current.val + " ");
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

                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _16_RightViewBinaryTree solution = new _16_RightViewBinaryTree();

        solution.root = new Node(10);
        solution.root.left = new Node(20);
        solution.root.right = new Node(30);
        solution.root.left.left = new Node(40);
        solution.root.left.right = new Node(50);
        solution.root.left.left.left = new Node(60);

        System.out.print("Right View (print method): ");
        solution.printRightView(solution.root);

        List<Integer> rightViewList = solution.rightSideView(solution.root);
        System.out.println("\nRight View (List method): " + rightViewList);
    }
}
