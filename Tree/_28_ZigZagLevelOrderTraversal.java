package Tree;

import java.util.*;

public class _28_ZigZagLevelOrderTraversal {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) { 
            this.val = val; 
        }
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Deque<Integer> levelNodes = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                if (leftToRight) {
                    levelNodes.addLast(currentNode.val);
                } else {
                    levelNodes.addFirst(currentNode.val);
                }

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            result.add(new ArrayList<>(levelNodes));
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        _28_ZigZagLevelOrderTraversal solution = new _28_ZigZagLevelOrderTraversal();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> zigzagOrder = solution.zigzagLevelOrder(root);
        System.out.println("Zigzag Level Order Traversal:");

        for (List<Integer> level : zigzagOrder) {
            System.out.println(level);
        }
    }
}
