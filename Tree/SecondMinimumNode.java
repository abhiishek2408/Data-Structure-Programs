
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
   
}

class SecondMinimumNode { 
    TreeNode root;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return findSecondMin(root, root.val);
    }

    private int findSecondMin(TreeNode node, int minValue) {
        if (node == null) return -1;
        if (node.val > minValue) return node.val;
        
        int leftSecondMin = findSecondMin(node.left, minValue);
        int rightSecondMin = findSecondMin(node.right, minValue);
        
        if (leftSecondMin == -1) return rightSecondMin;
        if (rightSecondMin == -1) return leftSecondMin;
        
        return Math.min(leftSecondMin, rightSecondMin);
    }
    
    public static void main(String[] args) {
        
        SecondMinimumNode tree = new SecondMinimumNode();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
    
        System.out.println("Maximum value in the binary tree is " + tree.findSecondMinimumValue(tree.root));
    }
}
