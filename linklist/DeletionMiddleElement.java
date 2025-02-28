public class DeletionMiddleElement {

    // Node class representing each element in the LinkedList
    static class Node {
        int data;      // Data stored in the node
        Node next;     // Reference to the next node

        // Constructor to initialize a new node
        Node(int data) {
            this.data = data;
            this.next = null; // Initially, the next reference is null
        }
    }

    // Head of the LinkedList (the starting point of the list)
    private Node head;

    // Method to delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) { // If the list is empty
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (position == 1) { // If the position is the first node
            System.out.println("Deleting node with data: " + head.data);
            head = head.next; // Update head to the next node
            return;
        }

        // Traverse to the node just before the position to be deleted
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is out of bounds
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        // Delete the node at the specified position
        System.out.println("Deleting node with data: " + temp.next.data);
        temp.next = temp.next.next; // Update the next pointer to skip the node
    }

    // Method to traverse and print the LinkedList
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;          // Start from the head of the list
        while (temp != null) {     // Loop until the end of the list is reached
            System.out.print(temp.data + " -> ");
            temp = temp.next;      // Move to the next node
        }
        System.out.println("null"); // Print null to indicate the end of the list
    }

    // Method to insert a new node at the end (for demonstration purposes)
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty
            head = newNode;
            return;
        }

        Node temp = head; // Start from the head
        while (temp.next != null) { // Traverse to the last node
            temp = temp.next;
        }
        temp.next = newNode; // Link the last node to the new node
    }

    // Main method
    public static void main(String[] args) {
        DeletionMiddleElement list = new DeletionMiddleElement();

        // Insert nodes
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        // Display the list
        System.out.println("Original LinkedList:");
        list.traverse();

        // Delete node at position 2
        list.deleteAtPosition(2);
        System.out.println("LinkedList after deleting node at position 2:");
        list.traverse();

        // Delete node at position 1
        list.deleteAtPosition(1);
        System.out.println("LinkedList after deleting node at position 1:");
        list.traverse();

        // Attempt to delete a node at an invalid position
        list.deleteAtPosition(5);
        System.out.println("LinkedList after attempting to delete at position 5:");
        list.traverse();
    }
}
