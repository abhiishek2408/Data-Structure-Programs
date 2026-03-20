//Checks if there exists at least one root-to-leaf path such that the sum of the nodes equals the targetSum.
package Tree;

class __CheckPathSumEqualToTarget {

    static class TreeNode {
        int val;
        TreeNode left, right;
    
        TreeNode(int value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }

    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Reduce target sum and check subtrees
        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        /*
            Sample Tree:
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
            Path with sum = 22 exists: 5 → 4 → 11 → 2
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        __CheckPathSumEqualToTarget solution = new __CheckPathSumEqualToTarget();

        int targetSum = 22;
        boolean result = solution.hasPathSum(root, targetSum);

        System.out.println("Path with sum " + targetSum + " exists: " + result);
    }
}

