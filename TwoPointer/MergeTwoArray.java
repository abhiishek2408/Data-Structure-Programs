package TwoPointer;

public class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for merged array

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }


    public static void main(String[] args) {
        MergeTwoArray merger = new MergeTwoArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merger.merge(nums1, 3, nums2, 3);
        System.out.println(java.util.Arrays.toString(nums1)); // Output: [1, 2, 2, 3, 5, 6]
    }
}