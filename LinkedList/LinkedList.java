/*Design a singly linked list data structure that supports the following operations:
get(index): Retrieve the value of the node at the given index. If the index is invalid (i.e., less than 0 or greater than or equal to the length of the list), return -1.
addAtHead(val): Insert a node with the given value at the beginning of the linked list.
addAtTail(val): Append a node with the given value at the end of the linked list.
addAtIndex(index, val): Insert a node with the given value at the specified index. If the index equals the current length of the list, the node should be appended to the end. If the index is greater than the length, the node should not be inserted. If the index is less than or equal to 0, the node should be inserted at the head.
deleteAtIndex(index): Delete the node at the given index, if the index is valid.
You must implement the MyLinkedList class with these methods, ensuring that the operations perform correctly according to their specified behaviors. */


package LinkedList;

class MyLinkedList {
  
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
        } else {
            Node newNode = new Node(val);
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }
}

