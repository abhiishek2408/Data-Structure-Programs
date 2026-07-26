package ETPquestion;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate the area between the current left and right lines
            int area = Math.min(height[left], height[right]) * (right - left);
            // Update maxArea if we found a larger area
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer for the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));  // Output: 49
    }
}
