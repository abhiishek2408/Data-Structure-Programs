package LinkedList;

public class LengthOfLL {

    
    static class Node {
        int data;      
        Node next;     

        
        Node(int data) {
            this.data = data;
            this.next = null; 
        }
    }

    
    private Node head;

    
    public int findLength() {
        int length = 0;   
        Node temp = head; 

        
        while (temp != null) {
            length++;      
            temp = temp.next; 
        }

        return length;  
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

    
    public static void main(String[] args) {
        LengthOfLL list = new LengthOfLL();

        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        
        System.out.println("Original LinkedList:");
        list.traverse();

        
        int length = list.findLength();
        System.out.println("The length of the LinkedList is: " + length);
    }
}

