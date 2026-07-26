package Array;

public class _16_RearrangeArrayBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIndex = 0, negIndex = 1;
        for (int num : nums) {
            if (num > 0) {
                res[posIndex] = num;
                posIndex += 2;
            } else {
                res[negIndex] = num;
                negIndex += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeArray(nums);
        for (int num : result) System.out.print(num + " ");
    }
}
