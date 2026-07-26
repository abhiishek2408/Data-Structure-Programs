package LinkedList;

public class _32_RemoveNthNodeFromEnd {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        _32_RemoveNthNodeFromEnd sol = new _32_RemoveNthNodeFromEnd();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        System.out.print("Original List: ");
        printList(head);
        
        head = sol.removeNthFromEnd(head, 2);
        System.out.print("After removing 2nd from end: ");
        printList(head);
    }
}
