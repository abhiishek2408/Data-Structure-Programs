package LinkedList;

// Define the SearchTargetValue class
class SearchTargetValue {

    class Node {
        int data;
        Node next;
    
        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    Node head;

    // Method to add a new node to the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search for a target element
    public boolean search(int target) {
        Node current = head;
        while (current != null) {
            if (current.data == target) {
                return true;  // Element found
            }
            current = current.next;
        }
        return false;  // Element not found
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create an instance of SearchTargetValue
        SearchTargetValue list = new SearchTargetValue();
        
        // Add some nodes to the linked list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Print the linked list
        list.printList();

        // Search for an element
        int target = 30;
        if (list.search(target)) {
            System.out.println(target + " is found in the linked list.");
        } else {
            System.out.println(target + " is not found in the linked list.");
        }
    }
}


