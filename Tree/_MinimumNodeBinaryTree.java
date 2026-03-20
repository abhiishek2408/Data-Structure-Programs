package Tree;

public class _MinimumNodeBinaryTree {

    static class TreeNode {
        int key;
        TreeNode left, right;
    
        public TreeNode(int item) {
            this.key = item;
            this.left = this.right = null;
        }
    }

    TreeNode root;

    // Method to find the minimum value in the binary tree
    int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.key, Math.min(getMin(root.left), getMin(root.right)));
    }

    public static void main(String[] args) {
        _MinimumNodeBinaryTree tree = new _MinimumNodeBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println("Minimum value in the binary tree is " + tree.getMin(tree.root));
    }
}
