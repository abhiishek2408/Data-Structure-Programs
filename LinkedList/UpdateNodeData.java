package LinkedList;

public class UpdateNodeData {

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

    // Method to update a node's data with a specified value
    public boolean updateNodeData(int oldData, int newData) {
        Node temp = head;

        // Traverse the list to find the node with oldData
        while (temp != null) {
            if (temp.data == oldData) {
                temp.data = newData;  // Update the data
                return true;           // Return true to indicate success
            }
            temp = temp.next; // Move to the next node
        }

        return false;  // Return false if node with oldData is not found
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
        UpdateNodeData list = new UpdateNodeData();

        // Insert nodes into the list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        // Display the original LinkedList
        System.out.println("Original LinkedList:");
        list.traverse();

        // Update the node with data 30 to new data 35
        boolean updated = list.updateNodeData(30, 35);
        if (updated) {
            System.out.println("Node with data 30 updated to 35.");
        } else {
            System.out.println("Node with data 30 not found.");
        }
        System.out.println("LinkedList after updating data:");
        list.traverse();

        // Try updating a node that doesn't exist (e.g., node with data 50)
        updated = list.updateNodeData(50, 55);
        if (updated) {
            System.out.println("Node with data 50 updated to 55.");
        } else {
            System.out.println("Node with data 50 not found.");
        }
        System.out.println("LinkedList after trying to update node with data 50:");
        list.traverse();
    }
}

