package Tree;

import java.util.*;

// Definition for a binary tree node.

class _AverageOfLevels {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with root

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level
            double sum = 0; // Use double to store sum

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                sum += current.val;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(sum / levelSize); // Average = sum / count
        }

        return result;
    }

    public class Main {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
            );
    
            _AverageOfLevels sol = new _AverageOfLevels();
            List<Double> result = sol.averageOfLevels(root);
            System.out.println(result); // Output: [3.0, 14.5, 11.0]
        }
    }
    
}

