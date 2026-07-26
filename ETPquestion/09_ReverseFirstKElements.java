package ETPquestion;

import java.util.*;
import java.util.LinkedList;

public class ReverseFirstKElements {
    public static Queue<Integer> reverseFirstKElements(Queue<Integer> queue, int k) {
        if (k == 0 || queue.isEmpty()) return queue;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.offer(queue.poll());
        }

        return queue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }
        queue = reverseFirstKElements(queue, k);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
