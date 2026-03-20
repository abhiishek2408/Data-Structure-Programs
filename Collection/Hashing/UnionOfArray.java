package Collection.Hashing;

import java.util.HashSet;
import java.util.Set;

class UnionOfArray {
    public int[] union(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();

        // Add all elements from the first array to the set
        for (int num : nums1) {
            resultSet.add(num);
        }

        // Add all elements from the second array to the set
        for (int num : nums2) {
            resultSet.add(num);
        }

        // Convert the result set to an array and return it
        int[] resultArray = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            resultArray[index++] = num;
        }

        return resultArray;
    }

    public static void main(String[] args) {
        UnionOfArray solution = new UnionOfArray();

        // Test the union method
        int[] nums1 = { 1, 2, 6, 8 };
        int[] nums2 = { 2, 5 };

        int[] result = solution.union(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " "); 
        }

        System.out.println();

        int[] nums3 = { 4, 9, 5 };
        int[] nums4 = { 9, 4, 9, 8, 4 };

        result = solution.union(nums3, nums4);
        for (int num : result) {
            System.out.print(num + " "); // Output: 4 9 5 8 (order can vary)
        }
    }
}