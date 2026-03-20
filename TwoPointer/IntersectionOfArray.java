package TwoPointer;

public class IntersectionOfArray {
    
    public static int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[Math.min(m, n)];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result[k++] = nums1[i];
                i++;
                j++;
            }
        }
        int[] finalResult = new int[k];
        System.arraycopy(result, 0, finalResult, 0, k);
        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersection = intersect(nums1, nums2);
        
        System.out.print("Intersection of the two arrays: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }
}
