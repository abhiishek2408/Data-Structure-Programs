
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class maxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        // Calculate the maximum path sum of the left and right subtrees
        int leftMax = Math.max(0, calculateMaxPathSum(node.left));
        int rightMax = Math.max(0, calculateMaxPathSum(node.right));

        // Update the maximum path sum for the current node
        int currentMax = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, currentMax);

        // Return the maximum path sum including the current node
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        maxPathSum solution = new maxPathSum();
        System.out.println("Maximum Path Sum (Example 1): " + solution.maxPathSum(root1)); // Output: 6

        // Example 2
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        System.out.println("Maximum Path Sum (Example 2): " + solution.maxPathSum(root2)); // Output: 42
    }
}