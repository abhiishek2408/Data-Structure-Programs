package ETPquestion;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to the head
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Helper method to print list (for testing)
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Sample usage
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                          new ListNode(2,
                          new ListNode(3,
                          new ListNode(4,
                          new ListNode(5)))));

        RemoveNode solution = new RemoveNode();
        int n = 2;
        ListNode result = solution.removeNthFromEnd(head, n);

        printList(result); // Output: 1 -> 2 -> 3 -> 5 -> null
    }
}

