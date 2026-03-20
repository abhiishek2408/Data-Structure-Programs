package Collection.Queue;

class QueueNode {
    int data;
    QueueNode next;

    // Constructor to create a new node
    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyQueue {
    QueueNode front, rear;

    // Constructor to initialize the queue
    MyQueue() {
        this.front = this.rear = null;
    }

    // Function to push an element into the queue.
    void push(int a) {
        QueueNode newNode = new QueueNode(a);

        // If queue is empty, then new node becomes both front and rear
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        // Add the new node at the end of the queue and change rear
        rear.next = newNode;
        rear = newNode;
    }

    // Function to pop front element from the queue.
    int pop() {
        // If queue is empty, return -1
        if (front == null) {
            return -1;
        }

        // Retrieve the data from the front node
        int poppedValue = front.data;

        // Move the front pointer to the next node
        front = front.next;

        // If front becomes null, make rear also null
        if (front == null) {
            rear = null;
        }

        return poppedValue;
    }
}

public class QueueUsingLL {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Pushing elements into the queue
        queue.push(10);
        queue.push(20);
        queue.push(30);

        // Displaying and popping elements
        System.out.println("Popped: " + queue.pop()); // Output: 10
        System.out.println("Popped: " + queue.pop()); // Output: 20

        // Pushing another element
        queue.push(40);

        // Continuing popping
        System.out.println("Popped: " + queue.pop()); // Output: 30
        System.out.println("Popped: " + queue.pop()); // Output: 40

        // Trying to pop from an empty queue
        System.out.println("Popped: " + queue.pop()); // Output: -1
    }
}
