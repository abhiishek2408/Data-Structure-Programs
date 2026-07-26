package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _15_LeftViewBinaryTree {
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

    _15_LeftViewBinaryTree() {
        this.root = null;
    }

    // Left View
    void printLeftView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (i == 0) {
                    System.out.print(current.val + " ");
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        _15_LeftViewBinaryTree solution = new _15_LeftViewBinaryTree();

        solution.root = new Node(10);
        solution.root.left = new Node(20);
        solution.root.right = new Node(30);
        solution.root.left.left = new Node(40);
        solution.root.left.right = new Node(50);
        solution.root.left.left.left = new Node(60);

        System.out.print("Left View: ");
        solution.printLeftView(solution.root);
        System.out.println();
    }
}
