package Collection.Stack;
// Class for Node
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class for Stack using Linked List
public class StackUsingLinkedList {
    private Node top;

    public StackUsingLinkedList() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        if(newNode == null){
            System.out.println("Stack overflow. Unable to push.");
        }
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack.");
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Unable to pop.");
            return -1; // Return a sentinel value
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Peek the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1; // Return a sentinel value
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        Node current = top;
        System.out.println("Stack elements:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the stack
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element is: " + stack.pop());
        stack.display();

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}