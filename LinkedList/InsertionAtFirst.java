package LinkedList;

public class InsertionAtFirst {

    // Node class representing each element in the LinkedList
    static class Node {
        int data;      // Data stored in the node
        Node next;     // Reference to the next node

        // Constructor to initialize a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the LinkedList
    private Node head;

    // Method to insert a new node at the first position
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);  // Create a new node
        newNode.next = head;           // Point the new node's next to the current head
        head = newNode;                // Update the head to the new node
    }

    // Method to traverse and print the LinkedList
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;           // Start from the head
        while (temp != null) {      // Traverse until the end of the list
            System.out.print(temp.data + " -> "); // Print the data
            temp = temp.next;       // Move temp to the next node
        }
        System.out.println("null"); // End of the list
    }

    // Main method to demonstrate insertion at the first position
    public static void main(String[] args) {

        InsertionAtFirst list = new InsertionAtFirst(); // Create a LinkedList object
        // Insert elements at the first position
        list.insertAtFirst(30); // Insert 30 at the beginning
        list.insertAtFirst(20); // Insert 20 at the beginning
        list.insertAtFirst(10); // Insert 10 at the beginning

        // Traverse and display the LinkedList
        System.out.println("LinkedList after inserting elements at the first position:");
        list.traverse();
    }
}
