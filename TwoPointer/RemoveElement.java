package TwoPointer;

public class RemoveElement {
    
    public static int removeElement(int[] nums, int val) {
        int j = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j; 
    }

    public static int[] removeElementAndGetArray(int[] nums, int val) {
        int j = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        int[] result = new int[j];
        System.arraycopy(nums, 0, result, 0, j);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = removeElement(nums, val);
        
        System.out.println("New length after removing element: " + newLength);
        System.out.print("Array after removing element: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
