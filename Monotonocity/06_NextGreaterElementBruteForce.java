package Monotonocity;
public class NextGreaterElementBruteForce {

    public int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int nextGreater = -1; 
            boolean found = false; 

            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    found = true; 
                }
                if (found && nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break; 
                }
            }

            result[i] = nextGreater; 
        }

        return result;
    }

   

    public static void main(String[] args) {
        NextGreaterElementBruteForce solution = new NextGreaterElementBruteForce();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result1 = solution.nextGreaterElementI(nums1, nums2);
       

        
        System.out.print("Next Greater Elements: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }

    }
}
