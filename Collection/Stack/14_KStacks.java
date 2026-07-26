package Collection.Stack;
class KStacks {
    int[] arr;      // Array to hold stack elements
    int[] top;      // Array to store the top index of each stack
    int[] next;     // Array to store the next free or next stack element indices
    int free;       // Index of the first free slot in the array
    int k, n;       // Number of stacks (k) and size of the array (n)

    // Constructor to initialize K stacks in a single array of size n
    KStacks(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        top = new int[k];
        next = new int[n];
        free = 0;

        // Initialize all stacks as empty
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        // Initialize the free list
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }

        next[n - 1] = -1; // -1 indicates the end of the free list
    }

    // Push an element x into stack number stackNum (0-based indexing)
    boolean push(int stackNum, int x) {
        // Check for overflow (no free space left)
        if (free == -1) {
            return false; // Array is full
        }

        int i = free;     // Get the first free slot
        free = next[i];   // Update the free slot to the next index in the free list

        next[i] = top[stackNum]; // Link the new element to the previous top of the stack
        top[stackNum] = i;       // Update the top index for the stack

        arr[i] = x; // Add the element to the array
        return true;
    }

    // Pop an element from stack number stackNum (0-based indexing)
    Integer pop(int stackNum) {
        // Check for underflow (stack is empty)
        if (top[stackNum] == -1) {
            return null; // Stack is empty
        }

        int i = top[stackNum];    // Get the top element index
        top[stackNum] = next[i];  // Update the top index to the next element in the stack

        next[i] = free; // Add the removed slot to the free list
        free = i;

        return arr[i]; // Return the popped element
    }

    // Get the size of a specific stack
    int size(int stackNum) {
        int count = 0;
        int i = top[stackNum];
        while (i != -1) {
            count++;
            i = next[i];
        }
        return count;
    }
    
    // Check if a specific stack is empty
    boolean isEmpty(int stackNum) {
        return top[stackNum] == -1;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create a KStacks object with 3 stacks and a total capacity of 10
        KStacks stacks = new KStacks(3, 10);

        // Push elements into the first stack
        stacks.push(0, 10);
        stacks.push(0, 20);
        stacks.push(0, 30);

        // Push elements into the second stack
        stacks.push(1, 40);
        stacks.push(1, 50);
        stacks.push(1, 60);

        // Push elements into the third stack
        stacks.push(2, 70);
        stacks.push(2, 80);
        stacks.push(2, 90);

        // Pop elements from each stack
        System.out.println("Popped from stack 0: " + stacks.pop(0));
        System.out.println("Popped from stack 1: " + stacks.pop(1));
        System.out.println("Popped from stack 2: " + stacks.pop(2));

        // Print sizes of the stacks
        System.out.println("Size of stack 0: " + stacks.size(0));
        System.out.println("Size of stack 1: " + stacks.size(1));
        System.out.println("Size of stack 2: " + stacks.size(2));

        // Check if a stack is empty
        System.out.println("Is stack 0 empty? " + stacks.isEmpty(0));
    }
}
