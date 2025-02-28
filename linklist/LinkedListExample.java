

public class LinkedListExample {

    static class Node {
        int data;     
        Node next;    

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    
    private Node head;

    // Constructor to initialize the list with some nodes for traversal
    public LinkedListExample() {
        // Example list: 10 -> 20 -> 30 -> 40
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
    }

    // Method to traverse the LinkedList and print all its elements
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty."); // If the list is empty
            return;
        }
        Node temp = head;           // Start from the head
        while (temp != null) {      // Traverse until the end of the list
            System.out.print(temp.data + " -> "); // Print the data
            temp = temp.next;    // Move to the next node
        }
        System.out.println("null");    // End of the list
    }

    // Main method to demonstrate traversal of the LinkedList
    public static void main(String[] args) {
        LinkedListExample list = new LinkedListExample(); // Create a LinkedList object

        // Traverse and display the list
        System.out.println("Elements in the LinkedList:");
        list.traverse();
    }
}
