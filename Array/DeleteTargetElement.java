public class DeleteTargetElement {
   
    
        public int removeDuplicates(int[] nums, int target) {
            if (nums.length == 0) return 0;
    
            int k = 1; 
    
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != target) { 
                    nums[k] = nums[i];       
                    k++;
                }
            }
    
            return k; 
        }
    
        public static void main(String[] args) {
            DeleteTargetElement solution = new DeleteTargetElement();
    
            
            int[] nums = {1, 2, 3, 4, 5, 6, 7};
            int target = 4;
            int k = solution.removeDuplicates(nums, target);
    
            System.out.println("Number of elements: " + k);
            System.out.print("Modified array: ");
            for (int i = 0; i < k; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }
    

