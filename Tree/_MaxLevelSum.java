package Tree;

import java.util.*;

// Definition for a binary tree node.


class _MaxLevelSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {}
    
        TreeNode(int val) { 
            this.val = val; 
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            // Sum all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Update max sum and level if needed
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;
        }

        return maxLevel;
    }

    public class Main {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1,
                new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
                new TreeNode(0)
            );
    
            _MaxLevelSum sol = new _MaxLevelSum();
            int result = sol.maxLevelSum(root);
            System.out.println(result); // Output: 2
        }
    }
    
}
