package TwoPointerApproach;
class SquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squaredNumbers = new int[n];
        
        int left = 0;
        int right = n - 1; 
        int index = n - 1;
        
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                squaredNumbers[index] = leftSquare;
                left++;
            } else {
                squaredNumbers[index] = rightSquare;
                right--;
            }
            index--;
        }
        
        return squaredNumbers;
    }

 
 
 
    public static void main(String[] var0) {
       int[] var1 = new int[]{-4,-1,0,3,10}; //0 1 9 16 100 
       System.out.println("Original Array:");

       SquareOfSortedArray obj = new SquareOfSortedArray();

       for (int i : obj.sortedSquares(var1)) {
        System.out.print(i+" ");
       }

      }
 
       
       
    
 
 }