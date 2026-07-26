package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _20_MaxWidthBinaryTree {
    Node root;

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public int maxWidth(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int count = q.size();
            maxWidth = Math.max(maxWidth, count);

            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        _20_MaxWidthBinaryTree solution = new _20_MaxWidthBinaryTree();
        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        solution.root.right.right = new Node(6);
        
        System.out.println("Maximum width of the tree is: " + solution.maxWidth(solution.root));
    }
}
