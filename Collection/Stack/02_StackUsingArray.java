package Collection.Stack;


class StackUsingArray {
    private int[] stack;
    private int top;
    private int capacity;

    
    public StackUsingArray(int size) {
        stack = new int[size];
        capacity = size;
        top = -1; 
    }

    
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Unable to push " + value);
            return;
        }
        stack[++top] = value;
        System.out.println("Pushed " + value + " to the stack.");
    }

    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Unable to pop.");
            return -1; 
        }




        int poppedData = stack[top];
        top--;
        
        return poppedData;
    }

    
    public boolean isEmpty() {
        return top == -1;
    }

    
    public boolean isFull() {
        return top == capacity - 1;
    }

    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; 
        }
        return stack[top];
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        
        stack.push(60);

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        
        System.out.println("Top element is: " + stack.peek());

        
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
