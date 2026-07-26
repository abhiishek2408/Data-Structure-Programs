package TwoPointer;

public class PartitionIndex {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    

    public static void partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int pivot = nums[high];
        while (i < j) {
            while (i < j && nums[i] < pivot) i++;
            while (i < j && nums[j] >= pivot) j--;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        // Place pivot in correct position
        swap(nums, i, high);
    }

    public static void main(String[] args) {

        int nums[] = {9,12,3,5,14,10,10};

        System.out.println("Before Partitioning:");
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();

        partition(nums, 0, nums.length - 1);

        System.out.println("After Partitioning:");
        for(int num : nums)
            System.out.print(num + " ");
    }
}
