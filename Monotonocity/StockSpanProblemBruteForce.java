package Monotonocity;
class StockSpanProblemBruteForce {

    // Function to calculate and print the stock span
    public static void printSpan(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    span++;
                } else {
                    break;
                }
            }
            System.out.print(span + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 18, 12, 13, 14, 11, 16 };
        int n = arr.length;
        printSpan(arr, n);
    }
}
