package Array;

import java.util.Arrays;


class CopyArray {
    

    // Copy the array manually using a for loop
    static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    // Copy the array using Arrays.copyOf utility method
    static int[] copyArrayUtil(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // Copy the array using System.arraycopy method
    static int[] copyArraySystem(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    // Copy a range of elements from the array (from index 'from' to 'to'-1)
    static int[] copyArrayRange(int[] arr, int from, int to) {
        return Arrays.copyOfRange(arr, from, to);
    }

    // Copy the array using the clone() method
    static int[] copyArrayClone(int[] arr) {
        return arr.clone();
    }

    


    public static void main(String[] args) {
        // Original array
        int[] arr = {1, 2, 3, 4, 5};

        // Copy using different methods
        int[] copied = copyArray(arr); // Manual for loop
        int[] copiedSystem = copyArraySystem(arr); // System.arraycopy
        int[] copiedUtil = copyArrayUtil(arr); // Arrays.copyOf
        int[] copiedClone = copyArrayClone(arr); // clone()
        int[] part = copyArrayRange(arr, 1, 4); // Arrays.copyOfRange (index 1 to 3)

        // Print copied range
        System.out.print("Copied range (index 1 to 3): ");
        for (int x : part) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Print array copied with manual loop
        System.out.print("Copied with loop: ");
        for (int x : copied) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Print array copied with System.arraycopy
        System.out.print("Copied with System.arraycopy: ");
        for (int x : copiedSystem) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Print array copied with Arrays.copyOf
        System.out.print("Copied with Arrays.copyOf: ");
        for (int x : copiedUtil) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Print array copied with clone()
        System.out.print("Copied with clone(): ");
        for (int x : copiedClone) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
