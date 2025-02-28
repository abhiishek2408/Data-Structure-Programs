
import java.util.Stack;

public class StackUsingCollection {
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();

    
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Initial Stack: " + stack);

        
        int topElement = stack.peek();
        System.out.println("Top Element (peek): " + topElement);

        
        int removedElement = stack.pop();
        System.out.println("Removed Element (pop): " + removedElement);
        System.out.println("Stack after pop: " + stack);

        
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is Stack Empty? " + isEmpty);

        
        int size = stack.size();
        System.out.println("Current Stack Size: " + size);
    }
}
