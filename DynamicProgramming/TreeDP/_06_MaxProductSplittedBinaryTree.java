package DynamicProgramming.TreeDP;
public class _06_MaxProductSplittedBinaryTree {
    static class TreeNode { int val; TreeNode left, right; }
    long maxProd = 0, totalSum = 0;
    public int maxProduct(TreeNode root) {
        totalSum = sum(root);
        sum(root);
        return (int)(maxProd % 1000000007);
    }
    private long sum(TreeNode node) {
        if (node == null) return 0;
        long subTreeSum = node.val + sum(node.left) + sum(node.right);
        maxProd = Math.max(maxProd, subTreeSum * (totalSum - subTreeSum));
        return subTreeSum;
    }
}