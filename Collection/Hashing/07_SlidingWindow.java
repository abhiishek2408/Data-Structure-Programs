package Collection.Hashing;
// Max sum of K elements in  pair
class SlidingWindow {
    
    public static int maxSum(int[] arr, int n, int k) {

        int curr = 0;
        
        for (int i = 0; i < k; i++) {// Calculate sum of first k elements
            curr += arr[i];
        }
        int res = curr;// Initialize result with current sum
        
        // Calculate sum of remaining windows by
        // removing first element of previous
        // window and adding last element of current window
    
        for (int i = k; i < n; i++) {
            curr = curr + arr[i] - arr[i-k];
            res = Math.max(res, curr);
        }
        
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        
        int maxSum = maxSum(arr, n, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSum);
    }
}