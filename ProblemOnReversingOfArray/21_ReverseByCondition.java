
// ReverseByCondition.java
// Reverses the array based on a given condition (example: reverse only if element is even)
/*
Example condition: Reverse only the even elements in the array
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}
Even elements: 2, 4, 6
After reverse: {1, 6, 3, 4, 5, 2, 7}
Output: 1 6 3 4 5 2 7
*/

class ReverseByCondition {

    // Reverse only the elements that satisfy the condition (here: even elements)
    static void reverseEvenElements(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        // Find the first even from left and right, then swap
        while (left < right) {
            while (left < right && arr[left] % 2 != 0) left++;
            while (left < right && arr[right] % 2 != 0) right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

  // Reverse only the elements that satisfy the condition (here: odd elements)
    static void reverseOddElements(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        // Find the first odd from left and right, then swap
        while (left < right) {
            while (left < right && arr[left] % 2 == 0) left++;
            while (left < right && arr[right] % 2 == 0) right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }


        // Reverse only the positive elements in the array
    static void reversePositiveElements(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] <= 0) left++;
            while (left < right && arr[right] <= 0) right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    // Reverse only the negative elements in the array
    static void reverseNegativeElements(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] >= 0) left++;
            while (left < right && arr[right] >= 0) right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    // Generic: Reverse elements by a custom condition (predicate)
    static void reverseByPredicate(int[] arr, java.util.function.IntPredicate predicate) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !predicate.test(arr[left])) left++;
            while (left < right && !predicate.test(arr[right])) right--;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reverseEvenElements(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
