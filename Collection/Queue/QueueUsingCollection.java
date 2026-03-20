package Collection.Queue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class QueueUsingCollection {
    public static void main(String[] args) {
        // Create a Queue of integers using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the Queue using add() or offer()
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        
        System.out.println("Original Queue: " + queue);

        // Remove an element from the Queue using poll() (removes and returns the front element)
        System.out.println("Removed element (poll): " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // Peek at the front element (without removing)
        System.out.println("Front element (peek): " + queue.peek());

        // Remove the front element using remove() (throws exception if queue is empty)
        System.out.println("Removed element (remove): " + queue.remove());
        System.out.println("Queue after remove: " + queue);

        // Check the size of the Queue
        System.out.println("Queue size: " + queue.size());

        // Check if Queue contains a specific element
        System.out.println("Queue contains 30? " + queue.contains(30));

        // Using Collections.shuffle() to shuffle the Queue (casting to LinkedList)
        Collections.shuffle((LinkedList<Integer>)queue);
        System.out.println("Shuffled Queue: " + queue);

        // Using Collections.reverse() to reverse the Queue (casting to LinkedList)
        Collections.reverse((LinkedList<Integer>)queue);
        System.out.println("Reversed Queue: " + queue);

        // Clear all elements in the Queue
        queue.clear();
        System.out.println("Queue after clear: " + queue);

        // Adding elements again to demonstrate final queue state
        queue.add(60);
        queue.add(70);
        queue.add(80);
        System.out.println("Queue after re-adding elements: " + queue);

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}
