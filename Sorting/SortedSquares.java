package Sorting;

public class SortedSquares {
  
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 0, right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                res[idx--] = leftSq;
                left++;
            } else {
                res[idx--] = rightSq;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SortedSquares solution = new SortedSquares();
        int[] nums = {-7, -3, 2, 3, 11};
        int[] result = solution.sortedSquares(nums);

        System.out.print("Sorted squares: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
