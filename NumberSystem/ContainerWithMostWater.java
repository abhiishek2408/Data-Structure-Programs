

// MaxAreaTwoPointers.java
// Implementation of maxArea (Container With Most Water) using two pointers (left, right)

/**
    * Visual representation of the two pointers approach for maxArea:
    * 
    * Given height = [1,8,6,2,5,4,8,3,7]
    * 
    * The maximum area is formed between the lines at index 1 (height 8) and index 8 (height 7).
    * The area is calculated as min(8, 7) * (8 - 1) = 7 * 7 = 49.
    * 
    * Visualization:
9 |                                        |    |        |    |
8 |    |                      |            |    |        |    |  
7 |    |                      |        |   |    |        |    |  
6 |    |    |                 |        |   |    |        |    |  
5 |    |    |        |        |        |   |    |        |    |  
4 |    |    |        |   |    |        |   |    |        |    |  
3 |    |    |        |   |    |   |    |   |    |    |    |    |   |    |  
2 |    |    |   |    |   |    |   |    |   |    |    |   |    |  
1 | |  |    |   |    |   |    |   |    |   |    |    |   |    |  
  ---------------------------------------------------------------
    0  1    2   3    4   5    6   7    8
 */

public class ContainerWithMostWater {
    /**
     * Finds the maximum area of water a container can store using two pointers.
     * @param height Array representing the height of lines
     * @return The maximum area
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // Example usage
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        System.out.println("Maximum area: " + result);
    }
}
