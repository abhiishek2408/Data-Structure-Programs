package Array;

public class _35_FindMissingAndRepeating {
    public static void findNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int missing = -1, repeating = -1;
        for (int num : nums) count[num]++;
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) missing = i;
            if (count[i] > 1) repeating = i;
        }
        System.out.println("Repeating: " + repeating + ", Missing: " + missing);
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 2, 1, 1};
        findNumbers(nums);
    }
}
