package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _BinaryTreeTraversal {
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

    _BinaryTreeTraversal() {
        this.root = null;
    }

    // In-order: Left → Root → Right
    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    // Pre-order: Root → Left → Right
    void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Post-order: Left → Right → Root
    void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Level-order: BFS using Queue
    void printLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    public static void main(String[] args) {
        _BinaryTreeTraversal binaryTree = new _BinaryTreeTraversal();

        // Build tree
        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(20);
        binaryTree.root.right = new Node(30);
        binaryTree.root.left.left = new Node(40);
        binaryTree.root.left.right = new Node(50);
        binaryTree.root.left.left.left = new Node(60);

        // Print all traversals
        System.out.print("In-order Traversal: ");
        binaryTree.printInOrder(binaryTree.root);
        System.out.println();

        System.out.print("Pre-order Traversal: ");
        binaryTree.printPreOrder(binaryTree.root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        binaryTree.printPostOrder(binaryTree.root);
        System.out.println();

        System.out.print("Level-order Traversal: ");
        binaryTree.printLevelOrder(binaryTree.root);
        System.out.println();
    }
}
