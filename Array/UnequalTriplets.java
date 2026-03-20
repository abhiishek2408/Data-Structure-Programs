package Array;
import java.util.*;

class Solution {
    public int unequalTriplets(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int left = 0;
        int right = nums.length;
        int count = 0;

        for (int f : freq.values()) {
            right -= f;
            count += left * f * right;
            left += f;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 4, 2, 4, 3};
        int result = sol.unequalTriplets(nums);
        System.out.println("Number of unequal triplets: " + result);
    }
}

//dry run
//nums = [4,4,2,4,3]  n= 5
//freq = {4:3, 2:1, 3:1}
//left = 0, right = 5, count = 0
//Iteration 1: f = 3 
// right = 5 - 3 = 2
// count = 0 + 0 * 3 * 2 = 0
// left = 0 + 3 = 3

//Iteration 2: f = 1
// right = 2 - 1 = 1
// count = 0 + 3 * 1 * 1 = 3
// left = 3 + 1 = 4

//Iteration 3: f = 1
// right = 1 - 1 = 0
// count = 3 + 4 * 1 * 0 = 3
// left = 4 + 1 = 5
//Final count = 3
//Triplets are (4,2,3), (2,4,3), (3,4,2)

//ans = 3

// analogy: choosing 1 from freq values at a time and calculating possible triplets with left and right sides.
//for example, a man is standing in the middle of a river (mid element from freq values).
//There are 'left' number of people on the left bank and 'right' number of people on the right bank.
//He can form triplets by choosing one person from the left bank and one from the right bank.
//So, the number of triplets formed with this man in the middle is left * f * right, where f is the frequency of the mid element.
//We repeat this for each unique element in the array (each frequency value) to get the total number of unequal triplets.