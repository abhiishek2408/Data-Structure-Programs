public class InsertionAtMiddle {

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

    // Method to insert a new node at a specific position
    public void insertAtMiddle(int data, int position) {
        // Step 1: Create a new node with the given data
        Node newNode = new Node(data);

        // Step 2: If the position is 1, insert at the beginning
        if (position == 1) {
            newNode.next = head; // Link the new node to the current head
            head = newNode;      // Update head to point to the new node
            return;              // Exit after insertion
        }

        // Step 3: Traverse to the node just before the desired position
        Node temp = head;        // Start from the head
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;    // Move to the next node
        }

        // Step 4: Check if the position is out of bounds
        if (temp == null) {      // If temp is null, the position is invalid
            System.out.println("Position out of bounds.");
            return;
        }

        // Step 5: Insert the new node in the middle
        newNode.next = temp.next; // Link the new node to the next node in the list
        temp.next = newNode;      // Link the previous node (temp) to the new node
    }

    // Method to traverse and print the LinkedList
    public void traverse() {
        Node temp = head;          // Start from the head of the list
        while (temp != null) {     // Loop until the end of the list is reached
            System.out.print(temp.data + " -> "); // Print the data of the current node
            temp = temp.next;      // Move to the next node
        }
        System.out.println("null"); // Print null to indicate the end of the list
    }

    // Main method
    public static void main(String[] args) {
        InsertionAtMiddle list = new InsertionAtMiddle(); // Create an empty linked list

        // Insert nodes
        list.insertAtMiddle(10, 1); // Insert 10 at position 1 (head)
        list.insertAtMiddle(20, 2); // Insert 20 at position 2 (end of the list)
        list.insertAtMiddle(30, 3); // Insert 30 at position 3 (end of the list)
        list.insertAtMiddle(15, 2); // Insert 15 at position 2 (middle)

        // Display the list
        System.out.println("LinkedList after insertions:");
        list.traverse();
    }
}
