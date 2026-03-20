public class Consecutive_Character_SubString {

        public int maxPower(String s) {
            int maxPower = 1, currentPower = 1;
            
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    currentPower++;
                    maxPower = Math.max(maxPower, currentPower);
                } else {
                    currentPower = 1;
                }
            }
            
            return maxPower;
        }
    
        public static void main(String[] args) {
            Consecutive_Character_SubString  solution = new Consecutive_Character_SubString ();
            String s = "abbcccddddeeeeedcba";
            System.out.println("Maximum Power: " + solution.maxPower(s));
        }
    }
    

