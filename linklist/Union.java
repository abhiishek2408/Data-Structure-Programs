import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Union {
    public static ListNode getUnion(ListNode head1, ListNode head2) {
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Add all elements from the first list to the set
        ListNode curr1 = head1;
        while (curr1 != null) {
            if (!set.contains(curr1.val)) {
                set.add(curr1.val);
                tail.next = new ListNode(curr1.val);
                tail = tail.next;
            }
            curr1 = curr1.next;
        }

        // Add all elements from the second list to the set (only unique values)
        ListNode curr2 = head2;
        while (curr2 != null) {
            if (!set.contains(curr2.val)) {
                set.add(curr2.val);
                tail.next = new ListNode(curr2.val);
                tail = tail.next;
            }
            curr2 = curr2.next;
        }

        return dummy.next;  // Return the head of the new list
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating first linked list: 1 -> 2 -> 3 -> 4
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        // Creating second linked list: 3 -> 4 -> 5 -> 6
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(head1);
        System.out.println("List 2:");
        printList(head2);

        ListNode unionList = getUnion(head1, head2);
        System.out.println("Union of Lists:");
        printList(unionList);
    }
}
