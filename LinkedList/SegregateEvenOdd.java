package LinkedList;

public class SegregateEvenOdd {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Function to segregate even and odd elements in the same LinkedList
    void segregateEvenOdd() {
        if (head == null || head.next == null) {
            return; // If 0 or 1 element, no need to segregate
        }

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        Node current = head;

        while (current != null) {
            int value = current.data;

            if (value % 2 == 0) { // Even Node
                if (evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else { // Odd Node
                if (oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        // If there are no even or no odd nodes, return
        if (evenStart == null || oddStart == null) {
            return;
        }

        // Attach even list to odd list
        evenEnd.next = oddStart;
        oddEnd.next = null; // Mark the end of the odd list

        // Update head to start of even list
        head = evenStart;
    }

    // Function to insert a new node at the end of the list
    void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    // Function to print the LinkedList
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SegregateEvenOdd list = new SegregateEvenOdd();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);

        System.out.println("Original Linked List:");
        list.printList();

        list.segregateEvenOdd();

        System.out.println("Modified Linked List (Even followed by Odd):");
        list.printList();
    }
}
