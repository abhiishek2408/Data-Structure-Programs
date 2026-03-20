package Collection.Queue;

class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        arr[rear] = x;
        rear++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if (rear == front) {
            return -1; // Queue is empty
        }

        int poppedValue = arr[front];
        // Shift all elements one position to the left
        for (int i = front; i < rear - 1; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return poppedValue;
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Test push operation
        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Popped element: " + queue.pop()); // Expected: 10
        System.out.println("Popped element: " + queue.pop()); // Expected: 20

        queue.push(40);

        System.out.println("Popped element: " + queue.pop()); // Expected: 30
        System.out.println("Popped element: " + queue.pop()); // Expected: 40
        System.out.println("Popped element: " + queue.pop()); // Expected: -1 (Queue is empty)
    }
}