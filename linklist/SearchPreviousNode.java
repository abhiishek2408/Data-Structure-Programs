// Define the Node class
class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define the SearchTargetValue class
class SearchPreviousNode {
    Node head;
    
    // Method to search for the target element and return its previous node
    public Node searchPrevious(int target) {
        Node current = head;
        Node previous = null;
    
        while (current != null && current.data != target) {   // target 5 
            previous = current;                               // LL 4=>6=>3=>8=>5=>6
            current = current.next;
        }

        if(current==null) return null; // Return null if the target node is not found
        
        return previous;  
    }

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
        SearchPreviousNode list = new SearchPreviousNode();
        
        // Add some nodes to the linked list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Print the linked list
        list.printList();

        // Search for the previous node of a target element
        int target = 40;
        Node previousNode = list.searchPrevious(target);
        
        if (previousNode != null) {
            System.out.println("Previous node of " + target + " is: " + previousNode.data);
        } else {
            System.out.println("No previous node found for " + target + " (either it's the first node or not found).");
        }
    }
}

