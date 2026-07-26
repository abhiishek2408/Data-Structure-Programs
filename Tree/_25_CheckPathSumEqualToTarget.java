package Tree;

public class _25_CheckPathSumEqualToTarget {

    static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        _25_CheckPathSumEqualToTarget solution = new _25_CheckPathSumEqualToTarget();
        int targetSum = 22;
        boolean result = solution.hasPathSum(root, targetSum);

        System.out.println("Path with sum " + targetSum + " exists: " + result);
    }
}
