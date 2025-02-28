public class RemoveDuplicateEfficient {
    
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { 
                nums[k] = nums[i];       
                k++;
            }
        }

        return k; 
    }

    public static void main(String[] args) {
        RemoveDuplicateEfficient solution = new RemoveDuplicateEfficient();

        
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 5};
        int k = solution.removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
