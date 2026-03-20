package Tree;



public class _MaximumNodeBinaryTree {

    static class TreeNode {
        int key;
        TreeNode left, right;
    
        public TreeNode(int item) {
            key = item;
            left = right = null;
        }
    }
    
    TreeNode root;

    // Method to find the maximum value in the binary tree
    int getMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
        }
    }

    public static void main(String[] args) {
        _MaximumNodeBinaryTree tree = new _MaximumNodeBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
    
        System.out.println("Maximum value in the binary tree is " + tree.getMax(tree.root));
    }
}
