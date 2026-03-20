package Array;

// Hindi Explanation:
// Trapping Rain Water समस्या में, आपको एक array दी जाती है जिसमें हर index पर एक इमारत (bar) की ऊँचाई दी गई है। बारिश के बाद, इन इमारतों के बीच में कितना पानी जमा हो सकता है, यह निकालना है।
//
// उदाहरण:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//
// Brute Force तरीका:
// हर index के लिए, उसके बाएँ और दाएँ सबसे ऊँची इमारत खोजो। फिर उस index पर जमा पानी = min(बाएँ की ऊँचाई, दाएँ की ऊँचाई) - उस index की ऊँचाई।
// इसे हर index के लिए दोहराओ।
//
// Optimal तरीका (Two Pointers):
// दो pointers (left, right) से शुरू करो। बाएँ और दाएँ की maximum ऊँचाई को ट्रैक करो।
// हर बार छोटे bar की तरफ से पानी जोड़ो और pointer को आगे बढ़ाओ।
//
// दोनों तरीकों से एक ही उत्तर मिलेगा, लेकिन optimal तरीका तेज़ है।


// Trapping Rain Water Problem
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
// Example:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//
// Dotted Diagram:
//
//      .               
//      .   .       .   
//  .   . . . .   . .   
//  . . . . . . . . . . 
//  0 1 0 2 1 0 1 3 2 1 2 1
//
// Water trapped is shown by the spaces between the bars (dots).


public class TrappingRainWater {

    // 1. Brute Force approach
    public int trapBruteForce(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = height[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = height[i];
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }

    // Function to calculate trapped rain water
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }


    public int trapoptimal(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (l < r) {
            if (height[l] > leftMax) {
                leftMax = Math.max(leftMax, height[l]);
            }

            if (height[r] > rightMax) {
                rightMax = Math.max(rightMax, height[r]);
            }

            if (leftMax < rightMax) {
                water += leftMax - height[l];
                l++;
            } else {
                water += rightMax - height[r];
                r--;
            }
        }

        return water;
    }

    // Example usage
    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped water (Optimal): " + solution.trap(height)); // Output: 6
        System.out.println("Trapped water (Brute Force): " + solution.trapBruteForce(height)); // Output: 6
    }
}
