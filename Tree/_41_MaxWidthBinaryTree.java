package Tree;

import java.util.*;

public class _41_MaxWidthBinaryTree {

    static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }
    
    static class Pair {
        Node node;
        int index;
    
        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(Node root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                Node node = current.node;
                int index = current.index - minIndex;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    queue.offer(new Pair(node.left, 2 * index));
                if (node.right != null)
                    queue.offer(new Pair(node.right, 2 * index + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);

        _41_MaxWidthBinaryTree solution = new _41_MaxWidthBinaryTree();
        int result = solution.widthOfBinaryTree(root);
        System.out.println("Maximum Width of Binary Tree: " + result);
    }
}
