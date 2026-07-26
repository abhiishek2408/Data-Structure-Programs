package Monotonocity;

public class NextGreaterElementNaive {
    
    public static int[] nextGreaterElementII(int[] nums1) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
         int nextGreater = -1;
            for (int j = i+1; j < nums1.length; j++) {
                if (nums1[j] > nums1[i]) {
                    nextGreater = nums1[j];
                    break;
                }
               
            }

            result[i] = nextGreater; 
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{3,7,9,2,5}; // 5 9 -1 5 -1

        int[] result = nextGreaterElementII(arr);

        System.out.print("Next Greater Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
