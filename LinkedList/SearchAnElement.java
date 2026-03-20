package LinkedList;

public class SearchAnElement {

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

    // Method to search for a specific element in the LinkedList
    public int searchElement(int data) {
        Node temp = head;
        int position = 1;

        // Traverse the list
        while (temp != null) {
            if (temp.data == data) {
                return position; // Return the position if element is found
            }
            temp = temp.next; // Move to the next node
            position++; // Increment the position counter
        }

        return -1; // Return -1 if element is not found
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
        SearchAnElement list = new SearchAnElement();

        // Insert nodes into the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        // Display the original LinkedList
        System.out.println("Original LinkedList:");
        list.traverse();

        // Search for an element (e.g., 30)
        int position = list.searchElement(30);
        if (position != -1) {
            System.out.println("Element 30 found at position: " + position);
        } else {
            System.out.println("Element 30 not found in the list.");
        }

        // Search for a non-existing element (e.g., 50)
        position = list.searchElement(50);
        if (position != -1) {
            System.out.println("Element 50 found at position: " + position);
        } else {
            System.out.println("Element 50 not found in the list.");
        }
    }
}
