
public class SwapTwoNodeII {
    Node head;

    // Function to swap two nodes in the linked list
    public void swapNodes(int x, int y) {
        if (x == y) return;

        // Search for x (keep track of prevX and currX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, do nothing
        if (currX == null || currY == null) return;

        // If x is not head of linked list
        if (prevX != null) {
            prevX.next = currY;
        } else { // make y the new head
            head = currY;
        }

        // If y is not head of linked list
        if (prevY != null) {
            prevY.next = currX;
        } else { // make x the new head
            head = currX;
        }

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    // Function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SwapTwoNodeII list = new SwapTwoNodeII();
        list.head = new Node(10);
        list.head.next = new Node(15);
        list.head.next.next = new Node(12);
        list.head.next.next.next = new Node(13);
        list.head.next.next.next.next = new Node(20);
        list.head.next.next.next.next.next = new Node(14);

        System.out.println("Linked list before swapping:");
        list.printList();

        list.swapNodes(12, 20);

        System.out.println("Linked list after swapping:");
        list.printList();
    }
}
