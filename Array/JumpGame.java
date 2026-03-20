import java.util.*;

public class JumpGame {

    // Greedy approach to check if end is reachable (classic Jump Game)
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static int minJumps(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        int result1 = minJumps(nums1);
        System.out.println("Minimum jumps (nums1): " + result1);
        System.out.println("Can jump to end (nums1): " + canJump(nums1)); // true

        int result2 = minJumps(nums2);
        System.out.println("Minimum jumps (nums2): " + result2);
        System.out.println("Can jump to end (nums2): " + canJump(nums2)); // false
    }
}