public class CycleDetection {

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

    // Method to detect if the LinkedList contains a cycle
    public boolean hasCycle() {
        if (head == null) { // An empty list cannot have a cycle
            return false;
        }

        Node slow = head; // Slow pointer
        Node fast = head; // Fast pointer

        while (fast != null && fast.next != null) { // Ensure fast pointer and its next are valid
            slow = slow.next;           // Move slow pointer one step
            fast = fast.next.next;      // Move fast pointer two steps

            if (slow == fast) {         // If they meet, a cycle exists
                return true;
            }
        }

        return false; // If fast pointer reaches the end, no cycle exists
    }

    // Method to insert a new node at the end
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

    // Method to create a cycle in the LinkedList for testing
    public void createCycle(int position) {
        if (head == null || position < 1) {
            return;
        }

        Node temp = head;
        Node cycleNode = null;
        int counter = 1;

        // Traverse to the position where the cycle starts
        while (temp.next != null) {
            if (counter == position) {
                cycleNode = temp;
            }
            temp = temp.next;
            counter++;
        }

        // Link the last node to the cycleNode
        if (cycleNode != null) {
            temp.next = cycleNode;
        }
    }

    // Main method
    public static void main(String[] args) {
        CycleDetection list = new CycleDetection();

        // Insert nodes
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        // Check for a cycle before creating one
        System.out.println("Does LinkedList have a cycle? " + list.hasCycle()); // Output: false

        // Create a cycle at position 2
        list.createCycle(2);

        // Check for a cycle after creating one
        System.out.println("Does LinkedList have a cycle? " + list.hasCycle()); // Output: true
    }
}

