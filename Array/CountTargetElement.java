public class CountTargetElement {
       
    public int countTargetElement(int[] nums, int var) {
        if (nums.length == 0) return 0;

        int count = 0; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == var) {        
                count++;
            }
        }

        return count; 
    }

    public static void main(String[] args) {
        CountTargetElement solution = new CountTargetElement();

        
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 5, 3};
        int target = 3;
        int k = solution.countTargetElement(nums, target);
        
        System.out.println("Number of "+ k +" in array is: " + k);
       
    }
}

