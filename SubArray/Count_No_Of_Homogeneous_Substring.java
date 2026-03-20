
public class Count_No_Of_Homogeneous_Substring {

        public int countHomogenous(String s) {
            int mod = 1_000_000_007;
            long count = 0;
            int length = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                    length++;
                } else {
                    length = 1;
                }
                count = (count + length) % mod;
            }
            
            return (int) count;
        }
    
        public static void main(String[] args) {
            Count_No_Of_Homogeneous_Substring solution = new Count_No_Of_Homogeneous_Substring();
            String s = "abbcccaa";
            System.out.println("Count of Homogenous Substrings: " + solution.countHomogenous(s));
        }
    }
    

