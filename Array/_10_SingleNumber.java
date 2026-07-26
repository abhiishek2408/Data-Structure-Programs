package Array;

public class _10_SingleNumber {
    public static int getSingleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single number: " + getSingleNumber(nums));
    }
}
