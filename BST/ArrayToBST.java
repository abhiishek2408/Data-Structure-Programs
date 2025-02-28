class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        
        return node;
    }

    // Helper method to print the tree in-order (for testing purposes)
    private void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        ArrayToBST solution = new ArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        
        TreeNode root = solution.sortedArrayToBST(nums);
        
        // Print the tree in-order to verify the result
        System.out.println("In-order traversal of the constructed BST:");
        solution.printInOrder(root);
    }
}