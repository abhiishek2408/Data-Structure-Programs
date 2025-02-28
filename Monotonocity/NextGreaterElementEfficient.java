package Monotonocity;
import java.util.*;

class NextGreaterElementeEfficient {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans.add(-1);
            } 
            else {
                ans.add(st.peek());
            }

            st.push(nums2[i]);
        }

        Collections.reverse(ans);

        // Map the next greater elements from nums2 to nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ans.size(); i++) {
            map.put(nums2[i], ans.get(i));
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    } 
    public static void main(String[] args) {
        NextGreaterElementeEfficient solution = new NextGreaterElementeEfficient();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solution.nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(result));  // Output: [-1, 3, -1]
    }
}

   

