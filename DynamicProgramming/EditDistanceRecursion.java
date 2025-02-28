package DynamicProgramming;
//Minimum Number of operation to convert  s1 into s2 by inserting,deleting & replacing
public class EditDistanceRecursion {

        // Recursive function to find the edit distance between two strings
        public int EditDistance(String s1, String s2, int m, int n) {
            // If the first string is empty, the only option is to insert all characters of the second string
            if (m == 0) return n;
    
            // If the second string is empty, the only option is to remove all characters of the first string
            if (n == 0) return m;
    
            // If the last characters are the same, ignore the last character and recur for the remaining strings
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                return EditDistance(s1, s2, m - 1, n - 1);
            }
    
            // If the last characters are different, consider all three operations on the last character of the first string
            // and take the minimum of the three operations
            return 1 + Math.min(Math.min(EditDistance(s1, s2, m, n - 1),EditDistance(s1, s2, m - 1, n)),EditDistance(s1, s2, m - 1, n - 1) );
                                      // Insert                              // Remove                                  // Replace
                
        }
    
        public static void main(String[] args) {
            EditDistanceRecursion editDistance = new EditDistanceRecursion();
            
            String s1 = "sunday";
            String s2 = "saturday";
            
            int result = editDistance.EditDistance(s1, s2, s1.length(), s2.length());
            System.out.println("Edit Distance between \"" + s1 + "\" and \"" + s2 + "\" is: " + result);
        }
    }

