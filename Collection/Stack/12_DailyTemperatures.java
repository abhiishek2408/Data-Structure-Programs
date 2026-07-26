package Collection.Stack;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove indices of days with temperatures less than or equal to the current day
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            
            // If the stack is not empty, the top of the stack gives the next warmer day
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dt.dailyTemperatures(temperatures);
        
        // Print the result
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
