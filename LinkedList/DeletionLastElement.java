package LinkedList;

public class DeletionLastElement {

    
    static class Node {
        int data;      
        Node next;     

        
        Node(int data) {
            this.data = data;
            this.next = null; 
        }
    }

    
    private Node head;

    
    public void deleteAtEnd() {
        if (head == null) { 
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) { 
            System.out.println("Deleting node with data: " + head.data);
            head = null; 
            return;
        }

        
        Node temp = head;
        while (temp.next.next != null) { 
            temp = temp.next;
        }

        
        System.out.println("Deleting node with data: " + temp.next.data);
        temp.next = null;
    }

    
    public void traverse() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head;          
        while (temp != null) {     
            System.out.print(temp.data + " -> ");
            temp = temp.next;      
        }
        System.out.println("null"); 
    }

    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) { 
            head = newNode;
            return;
        }

        Node temp = head; 
        while (temp.next != null) { 
            temp = temp.next;
        }
        temp.next = newNode; 
    }

    
    public static void main(String[] args) {
        DeletionLastElement list = new DeletionLastElement();

        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        
        System.out.println("Original LinkedList:");
        list.traverse();

        
        list.deleteAtEnd();
        System.out.println("LinkedList after deleting the last node:");
        list.traverse();

        
        list.deleteAtEnd();
        System.out.println("LinkedList after deleting the last node again:");
        list.traverse();

        
        list.deleteAtEnd();
        System.out.println("LinkedList after deleting the last node again:");
        list.traverse();
    }
}

