public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; // If the tree is empty, the minimum depth is 0
        }

        // If the node is a leaf node, return 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If one of the subtrees is null, we only consider the other subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both subtrees are present, return the minimum depth of both subtrees
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5); // Uncomment to add more nodes

        MinDepth solution = new MinDepth();
        int minDepth = solution.minDepth(root);
        System.out.println("Minimum Depth of the Binary Tree: " + minDepth);
    }
}