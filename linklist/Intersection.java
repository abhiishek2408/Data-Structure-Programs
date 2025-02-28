class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Intersection {
    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != curr2) {
            if (curr1 == null) {
                curr1 = head2;
            } else {
                curr1 = curr1.next;
            }

            if (curr2 == null) {
                curr2 = head1;
            } else {
                curr2 = curr2.next;
            }
        }

        return curr1; // Either the intersection node or null
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
        // Creating two linked lists that intersect
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(9);
        head1.next.next.next = common; // Intersection starts here

        ListNode head2 = new ListNode(4);
        head2.next = common; // Intersection starts here

        System.out.println("List 1:");
        printList(head1);
        System.out.println("List 2:");
        printList(head2);

        ListNode intersection = getIntersectionNode(head1, head2);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
