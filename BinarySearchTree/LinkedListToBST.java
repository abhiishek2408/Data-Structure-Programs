
public class LinkedListToBST {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return convertListToBST(head);
    }

    private TreeNode convertListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find the middle of the linked list
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half
        if (prev != null) {
            prev.next = null;
        }

        // Create root node
        TreeNode root = new TreeNode(slow.val);

        // Recursively create left and right subtrees
        if (head != slow) {
            root.left = convertListToBST(head);
        } else {
            root.left = null;
        }

        root.right = convertListToBST(slow.next);

        return root;
    }

     // Helper function to print inorder traversal of BST
     public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }


    public static void main(String[] args) {
        // Create a sorted linked list: -10 -> -3 -> 0 -> 5 -> 9
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        // Convert to BST
        LinkedListToBST solution = new LinkedListToBST();
        TreeNode bstRoot = solution.sortedListToBST(head);

        // Print inorder traversal of the BST
        System.out.print("Inorder Traversal of BST: ");
        inorderTraversal(bstRoot);
        System.out.println();
    }

   
}

