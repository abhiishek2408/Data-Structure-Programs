class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Height {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(countNodes(root.left) , countNodes(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Height solution = new Height();
        int count = solution.countNodes(root);
        System.out.println("Height of Binary Tree is: " + count);

    }
}
