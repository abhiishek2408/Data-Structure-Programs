package ETPquestion;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tempStack = new Stack<>();
        while (!input.isEmpty()) {
            int temp = input.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) stack.push(sc.nextInt());
        Stack<Integer> sortedStack = sortStack(stack);
        Iterator<Integer> itr = sortedStack.iterator();
        while (itr.hasNext()) {
            int elt = itr.next();
            System.out.print(elt + " ");
        }
    }
}
