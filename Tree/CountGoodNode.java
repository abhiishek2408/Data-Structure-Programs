package Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CountGoodNode {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int goodSum = 0;
        if (node.val >= maxSoFar) {
            goodSum = 1;
            maxSoFar = node.val;
        }

        goodSum += countGoodNodes(node.left, maxSoFar);
        goodSum += countGoodNodes(node.right, maxSoFar);

        return goodSum;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree:
        //     3
        //    / \
        //   1   4
        //  /   / \
        // 3   1   5

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        // Create an instance of CountGoodNode and count the good nodes
        CountGoodNode solution = new CountGoodNode();
        int goodNodesCount = solution.goodNodes(root);

        // Print the number of good nodes
        System.out.println("Number of good nodes: " + goodNodesCount);
    }
}
