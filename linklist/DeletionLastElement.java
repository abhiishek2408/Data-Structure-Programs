public class DeletionLastElement {

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

    // Method to delete the last node
    public void deleteAtEnd() {
        if (head == null) { // If the list is empty
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) { // If there is only one node
            System.out.println("Deleting node with data: " + head.data);
            head = null; // The list becomes empty
            return;
        }

        // Traverse to the second-last node
        Node temp = head;
        while (temp.next.next != null) { // Stop at the second-last node
            temp = temp.next;
        }

        // Delete the last node by updating the next of the second-last node
        System.out.println("Deleting node with data: " + temp.next.data);
        temp.next = null;
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
        DeletionLastElement list = new DeletionLastElement();

        // Insert nodes
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        // Display the list
        System.out.println("Original LinkedList:");
        list.traverse();

        // Delete the last node
        list.deleteAtEnd();
        System.out.println("LinkedList after deleting the last node:");
        list.traverse();

        // Delete again
        list.deleteAtEnd();
        System.out.println("LinkedList after deleting the last node again:");
        list.traverse();

        // Delete again
        list.deleteAtEnd();
        System.out.println("LinkedList after deleting the last node again:");
        list.traverse();
    }
}

