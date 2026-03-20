package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _LeftViewBinaryTree {
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

    _LeftViewBinaryTree() {
        this.root = null;
    }

    // Left View
    void printLeftView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Loop through all nodes in this level
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // First node of this level
                if (i == 0) {
                    System.out.print(current.data + " ");
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        _LeftViewBinaryTree binaryTree = new _LeftViewBinaryTree();

        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        binaryTree.root.left.left = new Node(40);
        binaryTree.root.left.right = new Node(50);
        binaryTree.root.left.left.left = new Node(60);

        // Print Left View
        System.out.print("Left View: ");
        binaryTree.printLeftView(binaryTree.root);
    }
}
