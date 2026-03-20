package Collection.Hashing;

import java.util.*;

class DifferenceOfArray  {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create sets from both arrays to ensure uniqueness of elements
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Fill sets with elements from both arrays
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Find the elements in nums1 that are not in nums2
        List<Integer> list1 = new ArrayList<>(set1);
        list1.removeAll(set2);  // Removes elements in set2 from list1
        
        // Find the elements in nums2 that are not in nums1
        List<Integer> list2 = new ArrayList<>(set2);
        list2.removeAll(set1);  // Removes elements in set1 from list2
        
        // Prepare the final answer
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);
        
        return answer;
    }

    public static void main(String[] args) {
        DifferenceOfArray solution = new DifferenceOfArray();
        
        // Test case 1
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        System.out.println(solution.findDifference(nums1, nums2));  // Output: [[1, 3], [4, 6]]
        
    
    }
}

