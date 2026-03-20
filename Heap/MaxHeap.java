package Heap;
// It's static heap (size can't grow) 
public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    // Constants
    private static final int FRONT = 1;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE; // Sentinel for easier comparisons
    }

    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return 2 * pos; }
    private int rightChild(int pos) { return 2 * pos + 1; }
    private boolean isLeaf(int pos) { return pos > size / 2 && pos <= size; }

    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Heapify the node at position pos
    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int largest = pos;

            if (left <= size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right <= size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != pos) {
                swap(pos, largest);
                maxHeapify(largest);
            }
        }
    }

    // Insert a value into the heap
    public void insert(int element) {
        if (size >= maxSize) {
            System.out.println("Heap is full");
            return;
        }

        heap[++size] = element;
        int current = size;

        // Move up while the heap property is violated
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove and return the maximum element
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        int max = heap[FRONT];
        heap[FRONT] = heap[size--];
        maxHeapify(FRONT);
        return max;
    }

    // Display the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i]
                             + " LEFT CHILD : " + heap[2 * i]
                             + " RIGHT CHILD :" + (2 * i + 1 <= size ? heap[2 * i + 1] : "null"));
            System.out.println();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(35);
        maxHeap.insert(33);
        maxHeap.insert(42);
        maxHeap.insert(10);
        maxHeap.insert(14);
        maxHeap.insert(19);
        maxHeap.insert(27);
        maxHeap.insert(44);
        maxHeap.insert(26);
        maxHeap.insert(31);

        maxHeap.print();

        System.out.println("\nThe max value is " + maxHeap.extractMax());

        System.out.println("\nHeap after extracting max:");
        maxHeap.print();
    }
}

