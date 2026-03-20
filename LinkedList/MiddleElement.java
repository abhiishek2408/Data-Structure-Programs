package LinkedList;

public class MiddleElement {

    
    static class Node {
        int data;      
        Node next;     

        
        Node(int data) {
            this.data = data;
            this.next = null; 
        }
    }

    
    private Node head;

    
    public Node findMiddle() {
        if (head == null) {
            return null;  
        }

        Node slow = head;  
        Node fast = head;  

        
        while (fast != null && fast.next != null) {
            slow = slow.next;          
            fast = fast.next.next;     
        }

        return slow;  
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
        MiddleElement list = new MiddleElement();

        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        
        System.out.println("Original LinkedList:");
        list.traverse();

        
        Node middle = list.findMiddle();
        if (middle != null) {
            System.out.println("The middle of the LinkedList is: " + middle.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
