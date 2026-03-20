package Searching;
public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // Not enough elements to determine second largest
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num < firstLargest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        try {
            int secondLargest = findSecondLargest(arr);
            System.out.println("Second largest element is: " + secondLargest);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
