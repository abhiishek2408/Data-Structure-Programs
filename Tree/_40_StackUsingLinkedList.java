package Tree;

public class _40_StackUsingLinkedList {
    
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node top;

    public _40_StackUsingLinkedList() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        System.out.println(val + " pushed to stack.");
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Unable to pop.");
            return -1;
        }
        int poppedData = top.val;
        top = top.next;
        return poppedData;
    }

    // Peek the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return -1;
        }
        return top.val;
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
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the stack
    public static void main(String[] args) {
        _40_StackUsingLinkedList solution = new _40_StackUsingLinkedList();

        solution.push(10);
        solution.push(20);
        solution.push(30);

        solution.display();

        System.out.println("Top element is: " + solution.peek());

        System.out.println("Popped element is: " + solution.pop());
        solution.display();

        System.out.println("Stack is empty: " + solution.isEmpty());
    }
}
