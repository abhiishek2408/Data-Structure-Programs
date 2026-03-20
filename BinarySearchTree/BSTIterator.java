import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructors
    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack;

    // Constructor
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    // Helper function to push all left children of a node
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Returns the next smallest number
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }

    // Returns whether we have a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Main method to test the iterator
    public static void main(String[] args) {
        // Constructing the BST
        TreeNode root = new TreeNode(7, 
                          new TreeNode(3), 
                          new TreeNode(15, new TreeNode(9), new TreeNode(20)));

        BSTIterator iterator = new BSTIterator(root);

        System.out.println(iterator.next());    // 3
        System.out.println(iterator.next());    // 7
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 9
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 15
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // 20
        System.out.println(iterator.hasNext()); // false
    }
}
