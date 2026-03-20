package LinkedList;

public class InsertionAtEnd {

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

    // Method to insert a new node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {           // If the list is empty
            head = newNode;           // Set the new node as the head
            return;
        }

        Node temp = head;             // Start from the head
        while (temp.next != null) {   // Traverse to the last node
            temp = temp.next;
        }
        temp.next = newNode;          // Link the last node to the new node
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

    // Main method to demonstrate insertion at the end
    public static void main(String[] args) {
        InsertionAtEnd list = new InsertionAtEnd(); // Create a LinkedList object

        // Insert elements at the end
        list.insertAtEnd(10); // Insert 10 at the end
        list.insertAtEnd(20); // Insert 20 at the end
        list.insertAtEnd(30); // Insert 30 at the end

        // Traverse and display the LinkedList
        System.out.println("LinkedList after inserting elements at the end:");
        list.traverse();
    }
}

