package Collection.Stack;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // Add the element to queue2
        queue2.add(x);
        
        // Add all elements of queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        
        // Swap the names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public int pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.remove();
    }
    
    public int top() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element: " + stack.top()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Top element after pop: " + stack.top()); // Output: 20
        System.out.println("Is stack empty? " + stack.empty()); // Output: false
        
        stack.pop();
        stack.pop();
        
        System.out.println("Is stack empty after popping all elements? " + stack.empty()); // Output: true
    }
}
