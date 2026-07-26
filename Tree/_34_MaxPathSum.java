package Tree;

public class _34_MaxPathSum {
    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        calculateMaxPathSum(root);
        return maxPathSum;
    }

    private int calculateMaxPathSum(Node node) {
        if (node == null) return 0;

        int leftMax = Math.max(0, calculateMaxPathSum(node.left));
        int rightMax = Math.max(0, calculateMaxPathSum(node.right));

        int currentMaxPathSum = node.val + leftMax + rightMax;
        maxPathSum = Math.max(maxPathSum, currentMaxPathSum);

        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        _34_MaxPathSum solution = new _34_MaxPathSum();

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        System.out.println("Maximum Path Sum (Example 1): " + solution.maxPathSum(root1)); // Output: 6

        Node root2 = new Node(-10);
        root2.left = new Node(9);
        root2.right = new Node(20);
        root2.right.left = new Node(15);
        root2.right.right = new Node(7);
        System.out.println("Maximum Path Sum (Example 2): " + solution.maxPathSum(root2)); // Output: 42
    }
}