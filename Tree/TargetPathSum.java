
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class TargetPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If the current node is null, return false
        if (root == null) {
            return false;
        }

        // If we reach a leaf node, check if the remaining sum equals the leaf's value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Subtract the current node's value from the target sum and check the left and right subtrees
        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        TargetPathSum solution = new TargetPathSum();
        int targetSum = 22;

        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println("Does the tree have a path sum of " + targetSum + "? " + result);
    }
}