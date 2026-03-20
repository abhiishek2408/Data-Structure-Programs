package Array;

class LargestAndSmallest {

    // Function to find largest element
    static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Function to find smallest element
    static int findSmallest(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9, 2};

        System.out.println("Largest element: " + findLargest(arr));
        System.out.println("Smallest element: " + findSmallest(arr));
    }
}
