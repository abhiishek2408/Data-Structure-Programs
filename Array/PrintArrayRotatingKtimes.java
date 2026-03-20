public class PrintArrayRotatingKtimes {
    
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k is greater than n

        // Reverse the entire array
        reverse(arr, 0, n - 1);
        // Reverse the first k elements
        reverse(arr, 0, k - 1);
        // Reverse the remaining n-k elements
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public int[] normalrotate(int[] arr, int k) {

    int n = arr.length;
    int[] res = new int[n];

    k = k % n;

    for(int i = 0; i < n; i++){
        res[(i + k) % n] = arr[i];
    }

    return res;
}

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        rotate(arr, k);

        System.out.print("Rotated Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
