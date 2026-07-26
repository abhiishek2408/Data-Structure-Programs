package LinkedList;

public class _22_SwapTwoNode {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node swapNodes(Node head, int k) {
        // Step 1: Find the length of the list
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Find the kth node from the beginning
        Node first = head;
        for (int i = 1; i < k; i++) {
            if (first != null) {
                first = first.next;
            }
        }

        // Step 3: Find the kth node from the end
        Node second = head;
        for (int i = 1; i < length - k + 1; i++) {
            if (second != null) {
                second = second.next;
            }
        }

        // Step 4: Swap the values of the two nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        _22_SwapTwoNode solution = new _22_SwapTwoNode();

        // Create a test list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        head = solution.swapNodes(head, k);

        System.out.println("List after swapping " + k + "th node from beginning and end:");
        printList(head);
    }
}
