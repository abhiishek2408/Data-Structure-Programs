class Solution {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node sortedInsert(Node head, int key) {
        Node newNode = new Node(key);
        
        // If list is empty or key should be inserted at beginning
        if (head == null || key < head.data) {
            newNode.next = head;
            return newNode;
        }
        
        // Find the position to insert
        Node current = head;
        while (current.next != null && current.next.data < key) {
            current = current.next;
        }
        
        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
        
        return head;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int key = 19;
        
        if (arr.length == 0) {
            return;
        }
        
        // Create linked list from array
        Node head = new Node(arr[0]);
        Node temp = head;
        
        for(int i = 1; i < arr.length; i++) {
            Node newnode = new Node(arr[i]);
            temp.next = newnode;   // Linking new node to the list
            temp = newnode;       // Moving temp to the new node
        }
        
        // Print original list
        System.out.println("Original List:");
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        
        // Insert new node
        head = sortedInsert(head, key);
        
        // Print list after insertion
        System.out.println("After insertion of " + key + ":");
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}