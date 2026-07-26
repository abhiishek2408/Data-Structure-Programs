package TwoPointerApproach;

public class MoveZeroes {
    
    public void moveZeroes(int[] arr) {
        int left = 0, right = 0;

        
        while (right < arr.length) {
            
            if (arr[right] != 0) {
                
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                
                left++;
            }
            
            right++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        
        
        int[] nums = {0, 1, 0, 3, 12};
        
        
        solution.moveZeroes(nums);
        
        
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
