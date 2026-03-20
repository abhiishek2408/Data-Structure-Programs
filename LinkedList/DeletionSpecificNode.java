package LinkedList;

public class DeletionSpecificNode {

    
    static class Node {
        int data; 
        Node next; 

        
        Node(int data) {
            this.data = data;
            this.next = null; 
        }
    }

    
    private Node head;

    
    public void deleteSpecificNode(int data) {
        if (head == null) { 
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        
        // if (head.data == data) {  // use only if doesn't remove all repeated data
        //     System.out.println("Deleting node with data: " + head.data);
        //     head = head.next; 
        //     return;
        // }

        while (head != null && head.data == data) { // use only if remove all repeated data too  
            head = head.next;
        }

        
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        
        if (temp.next == null) {
            System.out.println("Node with data " + data + " not found.");
            return;
        }

        
        System.out.println("Deleting node with data: " + temp.next.data);
        temp.next = temp.next.next; 
    }

    public void deleteSpecificNode1(int data) {
       
        Node current = head;
        Node slow = head;
        Node fast = head.next;

        if (head == null) { 
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        while(head!=null && current.data != data){
            slow = current;
            current = fast;
            fast = fast.next;
            if (fast==null) {
                System.out.println(data+" does not exist in the list" );
                return;
           }
        }
        slow.next = fast;
        
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
        DeletionSpecificNode list = new DeletionSpecificNode();

        
        // list.insertAtEnd(10);
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        
        System.out.println("Original LinkedList:");
        list.traverse();

        
        // list.deleteSpecificNode(30);
        // System.out.println("LinkedList after deleting node with data 30:");
        // list.traverse();

        
        // list.deleteSpecificNode(50);
        // System.out.println("LinkedList after trying to delete node with data 50:");
        // list.traverse();

        
        // list.deleteSpecificNode(10);
        list.deleteSpecificNode1(15);
        System.out.println("LinkedList after deleting node with data 15:");
        list.traverse();

        
        // list.deleteSpecificNode(40);
        // System.out.println("LinkedList after deleting last node with data 40:");
        // list.traverse();
    }
}
