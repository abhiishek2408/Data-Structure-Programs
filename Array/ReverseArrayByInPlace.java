public class ReverseArrayByInPlace {

    public static void reverseArray(int[] arr){ 
    
        int start = 0;           // Pointer to the beginning of the array
        int end = arr.length - 1; // Pointer to the end of the array

        // Swap elements until the two pointers meet
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

           
            start++; // Move the pointers closer
            end--;
        }
    }

   
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original Array:");
        printArray(arr);

        reverseArray(arr);

        System.out.println("Reversed Array:");
        printArray(arr);
    }
}
