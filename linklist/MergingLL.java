
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MergingLL {

    public static Node mergeLists(Node l1, Node l2) {
        // Dummy node to form the base of the new list
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists and pick the smaller value each time
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining part of the list, if any 
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the merged list, starting from the next of dummy node
        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating first sorted linked list: 1 -> 3 -> 5
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        // Merging the lists
        Node mergedList = mergeLists(l1, l2);

        // Printing the merged list
        System.out.print("Merged Linked List: ");
        printList(mergedList);
    }
}
