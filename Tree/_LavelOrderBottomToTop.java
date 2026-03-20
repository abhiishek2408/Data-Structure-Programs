package Tree;
import java.util.*;

// Definition for a binary tree node.


class _LavelOrderBottomToTop {

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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Nodes at the current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll(); // Get next node
                level.add(current.val); // Add its value to the current level list

                // Add left and right children to the queue if they exist
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.addFirst(level); // Add this level to the front of the result list
        }

        return result;
    }
}
