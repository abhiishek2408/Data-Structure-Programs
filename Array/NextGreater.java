public class NextGreater {
   //Find pivot element: From the right side, find the first position where the sequence decreases. 
   //Find the next greater element: From the right side, find the first element that is greater than the pivot element.
 
  public static int nextGreater(int[] nums) {
       

        int n = nums.length;
        int i = n - 2;

        // Step 1: find pivot
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if(i >= 0) {

            int j = n - 1;

            // Step 2: find next greater
            while(nums[j] <= nums[i]) {
                j--;
            }

        return nums[j];
        }

        
   return -1;
  }

        public static void main(String[] args) {
    
            int arr[] = {1, 2, 7, 4, 3, 1};
    
            System.out.println(nextGreater(arr));
        }

}
