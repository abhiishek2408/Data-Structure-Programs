public class DeletionFirstElement {

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

    // Method to delete the first node
    public void deleteAtFirst() {
        if (head == null) { // If the list is empty
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        // Update head to point to the next node
        System.out.println("Deleting node with data: " + head.data);
        head = head.next; // The first node is effectively removed
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
        DeletionFirstElement list = new DeletionFirstElement();

        // Insert nodes
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        // Display the list
        System.out.println("Original LinkedList:");
        list.traverse();

        // Delete the first node
        list.deleteAtFirst();
        System.out.println("LinkedList after deleting the first node:");
        list.traverse();

        // Delete again
        list.deleteAtFirst();
        System.out.println("LinkedList after deleting the first node again:");
        list.traverse();

        // Delete again
        list.deleteAtFirst();
        System.out.println("LinkedList after deleting the first node again:");
        list.traverse();
    }
}

