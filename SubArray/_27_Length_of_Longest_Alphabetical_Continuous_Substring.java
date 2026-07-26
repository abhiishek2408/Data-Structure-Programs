package SubArray;

public class _27_Length_of_Longest_Alphabetical_Continuous_Substring {
        public int longestContinuousSubstring(String s) {
            int maxLength = 1, currentLength = 1;
            
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) - s.charAt(i - 1) == 1) {
                    currentLength++;
                    maxLength = Math.max(maxLength, currentLength);
                } else {
                    currentLength = 1;
                }
            }
            
            return maxLength;
        }
    
        public static void main(String[] args) {
            _27_Length_of_Longest_Alphabetical_Continuous_Substring solution = new _27_Length_of_Longest_Alphabetical_Continuous_Substring();
            String s = "abacaba";
            System.out.println("Longest Continuous Substring Length: " + solution.longestContinuousSubstring(s));
        }
    }
    

    
   