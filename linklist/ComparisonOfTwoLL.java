

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ComparisonOfTwoLL {

    static boolean compareLists(Node list1, Node list2) {
        while (list1 != null && list2 != null) {
            if (list1.data != list2.data) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == null && list2 == null;
    }

    // Method to print a linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to create a linked list from an array
    static Node createList(int[] arr) {
        Node head = null;
        Node current = null;
        for (int value : arr) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // Create two linked lists
        int[] list1Values = { 1, 2, 3, 4, 5 };
        int[] list2Values = { 1, 2, 3, 4, 5 };
        int[] list3Values = { 1, 2, 3 };

        Node list1 = createList(list1Values);
        Node list2 = createList(list2Values);
        Node list3 = createList(list3Values);

        // Print the linked lists
        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        System.out.print("List 3: ");
        printList(list3);

        // Compare lists
        System.out.println("List 1 and List 2 are equal: " + compareLists(list1, list2));
        System.out.println("List 1 and List 3 are equal: " + compareLists(list1, list3));
    }
}

// Final Check: Once the loop ends, both lists should be completely traversed.
// If either list has remaining nodes (head1 != null || head2 != null), then the
// lists are of different lengths and are not equal.
