package LinkedList;

class DeleteMiddleElement {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    
    public ListNode deleteMiddle(ListNode head) {
        // If list is empty or has only one node
        if(head == null || head.next == null) {
            return null;
        }
        
        // If list has only two nodes
        if(head.next.next == null) {
            head.next = null;
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        // Find middle node with prev pointer
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Delete middle node
        prev.next = slow.next;
        
        return head;
    }
    
    public static void main(String[] args) {
        DeleteMiddleElement solution = new DeleteMiddleElement();
        
        // Create first test list: 1->2->3->4->5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        
        // Print original list
        System.out.print("Original List 1: ");
        ListNode temp = head1;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        
        // Delete middle and print result
        head1 = solution.deleteMiddle(head1);
        System.out.print("After deleting middle: ");
        temp = head1;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        
        // Create second test list: 1->2->3->4->5->6
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        
        // Print second list
        System.out.print("\nOriginal List 2: ");
        temp = head2;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        
        // Delete middle and print result
        head2 = solution.deleteMiddle(head2);
        System.out.print("After deleting middle: ");
        temp = head2;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}