//Finds all root-to-leaf paths where the sum of node values equals the target.
package Tree;

import java.util.ArrayList;
import java.util.List;


class __FindAllPathSumEqualToTarget {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    
    private void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        currentPath.add(node.val);
        
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }
        
        currentPath.remove(currentPath.size() - 1);
    }


    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Create a Solution object
        __FindAllPathSumEqualToTarget solution = new __FindAllPathSumEqualToTarget();

        // Find all paths that sum to the target
        int targetSum = 22;
        List<List<Integer>> paths = solution.pathSum(root, targetSum);

        // Print the result
        System.out.println("Paths that sum to " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
