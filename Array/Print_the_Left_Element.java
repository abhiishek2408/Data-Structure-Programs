import java.util.*;

public class Print_the_Left_Element {

    public static int leftElement(int[] arr) {
        Arrays.sort(arr); // Sort array in ascending order
        return arr[(arr.length - 1) / 2]; // Remaining element index
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 8, 3, 4, 2, 9, 5};
        System.out.println(leftElement(arr1)); // Expected: 5

        int[] arr2 = {8, 1, 2, 9, 4, 3, 7, 5};
        System.out.println(leftElement(arr2)); // Expected: 4

        int[] arr3 = {10};
        System.out.println(leftElement(arr3)); // Expected: 10
    }
}


/*Find the left over element
Difficulty: EasyAccuracy: 46.94%Submissions: 45K+Points: 2
Given an array arr[], the size is reduced by 1 element at each step. In the first step,
 the maximum element would be removed, while in the second step, the minimum element of 
 the remaining array would be removed, in the third step again the maximum, and so on. 
 Continue this till the array contains only one element. And find the final element remaining 
 in the array. */
