package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _03_BinaryTreeTraversal {
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

    _03_BinaryTreeTraversal() {
        this.root = null;
    }

    // In-order: Left → Root → Right
    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    // Pre-order: Root → Left → Right
    void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Post-order: Left → Right → Root
    void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.val + " ");
    }

    // Level-order: BFS using Queue
    void printLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.val + " ");

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    public static void main(String[] args) {
        _03_BinaryTreeTraversal solution = new _03_BinaryTreeTraversal();

        // Build tree
        solution.root = new Node(10);
        solution.root.left = new Node(20);
        solution.root.right = new Node(30);
        solution.root.left.left = new Node(40);
        solution.root.left.right = new Node(50);
        solution.root.left.left.left = new Node(60);

        // Print all traversals
        System.out.print("In-order Traversal: ");
        solution.printInOrder(solution.root);
        System.out.println();

        System.out.print("Pre-order Traversal: ");
        solution.printPreOrder(solution.root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        solution.printPostOrder(solution.root);
        System.out.println();

        System.out.print("Level-order Traversal: ");
        solution.printLevelOrder(solution.root);
        System.out.println();
    }
}
