public class SecondMinNumber {
    
    public static int findSecondMinimum(int[] nums) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num > min && num < secondMin) {
                secondMin = num;
            }
        }

        return secondMin == Integer.MAX_VALUE ? -1 : secondMin; // Return -1 if there is no second minimum
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9};
        System.out.println(findSecondMinimum(nums)); // Output: 3
    }
}
