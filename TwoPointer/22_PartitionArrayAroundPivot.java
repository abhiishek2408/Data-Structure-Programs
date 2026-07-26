package TwoPointer;

public class PartitionArrayAroundPivot {
    

    public static void partition(int[] nums, int pivot) {

    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while(mid <= high) {

        if(nums[mid] < pivot) {
            swap(nums, low, mid);
            low++;
            mid++;
        }

        else if(nums[mid] == pivot) {
            mid++;
        }

        else {
            swap(nums, mid, high);
            high--;
        }
    }
}

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int nums[] = {9, 12, 3, 5, 14, 10, 10};
        int pivot = 10;

        System.out.println("Before Partitioning:");
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();

        partition(nums, pivot);

        System.out.println("After Partitioning:");
        for(int num : nums)
            System.out.print(num + " ");
    }
}
