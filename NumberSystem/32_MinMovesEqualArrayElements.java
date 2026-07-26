public class MinMovesEqualArrayElements {
    public int minMoves(int[] nums) {
    int min = Integer.MAX_VALUE;
    int sum = 0;
    
    for(int num : nums){
        sum += num;
        min = Math.min(min, num);
    }
    
    return sum - nums.length * min;
}

public static void main(String[] args) {
    MinMovesEqualArrayElements solution = new MinMovesEqualArrayElements();
    int[] nums = {1, 2, 3};
    System.out.println(solution.minMoves(nums)); // Output: 3
}

}
