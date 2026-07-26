package Tree;

import java.util.*;

public class _36_CheckCompleteBinaryTree {

    static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    boolean isCompleteBT(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                foundNull = true;
            } else {
                if (foundNull) {
                    return false;
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        _36_CheckCompleteBinaryTree solution = new _36_CheckCompleteBinaryTree();
        boolean result = solution.isCompleteBT(root);

        System.out.println("Is the tree a Complete Binary Tree? " + (result ? "Yes" : "No"));
    }
}
