public class Longest_Contiguous_SegmentsOf_One_then_Zero {
        public boolean checkZeroOnes(String s) {
            int maxOnes = 0, maxZeros = 0;
            int countOnes = 0, countZeros = 0;
            
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    countOnes++;
                    countZeros = 0;
                } else {
                    countZeros++;
                    countOnes = 0;
                }
                maxOnes = Math.max(maxOnes, countOnes);
                maxZeros = Math.max(maxZeros, countZeros);
            }
            
            return maxOnes > maxZeros;
        }
    
        public static void main(String[] args) {
            Longest_Contiguous_SegmentsOf_One_then_Zero solution = new Longest_Contiguous_SegmentsOf_One_then_Zero();
            String s = "1101";
            System.out.println("Has longer contiguous ones than zeros: " + solution.checkZeroOnes(s));
        }
    }

