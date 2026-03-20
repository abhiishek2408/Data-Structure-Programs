package LinkedList;

public class ReverseLL {

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

    // Method to reverse the LinkedList
    public void reverse() {
        Node previous = null; // Initially, previous is null
        Node current = head;  // Start from the head
        Node next = null;     // To store the next node

        while (current != null) {
            next = current.next; // Save the next node
            current.next = previous; // Reverse the current node's next pointer
            previous = current; // Move previous to current node
            current = next; // Move to the next node
        }

        head = previous; // Set the head to the last node (new head)
    }

    // Method to insert a new node at the end (for testing purposes)
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

    // Method to traverse and print the LinkedList
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head; // Start from the head of the list
        while (temp != null) { // Loop until the end of the list is reached
            System.out.print(temp.data + " -> ");
            temp = temp.next; // Move to the next node
        }
        System.out.println("null"); // Print null to indicate the end of the list
    }

    // Main method
    public static void main(String[] args) {
        ReverseLL list = new ReverseLL();

        // Insert nodes into the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        // Display the original LinkedList
        System.out.println("Original LinkedList:");
        list.traverse();

        // Reverse the LinkedList
        list.reverse();

        // Display the reversed LinkedList
        System.out.println("Reversed LinkedList:");
        list.traverse();
    }
}
