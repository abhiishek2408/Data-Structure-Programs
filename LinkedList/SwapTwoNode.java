package LinkedList;

class SwapTwoNode {

    static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        
    public ListNode swapNodes(ListNode head, int k) {
        // Step 1: Find the length of the list
        int length = 0;
        ListNode current = head;
        
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Step 2: Find the kth node from the beginning
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        
        // Step 3: Find the kth node from the end
        ListNode second = head;
        for (int i = 1; i < length - k + 1; i++) {
            second = second.next;
        }
        
        // Step 4: Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}


/*Preserving the head reference: Using current ensures the list structure is not accidentally modified during traversal.
Avoiding side effects: It preserves the integrity of the linked list, so you can safely use head later for other operations.
It makes the code cleaner and safer to avoid side effects while traversing. */


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
