package Tree;

import java.util.*;

public class _14_MaxLevelSum {

    static class Node {
        int val;
        Node left;
        Node right;
    
        Node(int val) { 
            this.val = val; 
        }
    }
    
    public int maxLevelSum(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(0);
        root.left.left = new Node(7);
        root.left.right = new Node(-8);

        _14_MaxLevelSum solution = new _14_MaxLevelSum();
        int result = solution.maxLevelSum(root);
        System.out.println("Level with maximum sum: " + result); // Expected: 2
    }
}
