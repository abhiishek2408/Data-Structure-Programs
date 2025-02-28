package DynamicProgramming;
//Litcode: 72. Edit Distance algorithm, also known as the Levenshtein distance
//Minimum Number of operation to convert  s1 into s2 by inserting,deleting & replacing
/*This algorithm calculates the minimum number of operations required to convert one string 
into another. The allowed operations are insertion, deletion, and substitution of a single character. */
public class EditDistanceDP {

// Function to find the edit distance between two strings using dynamic programming        
        public int eD(String s1, String s2, int m, int n) {
            // Create a table to store results of subproblems
            int[][] dp = new int[m + 1][n + 1];
    
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }

            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }
            // Fill dp[][] in bottom-up manner
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // If the last characters are the same, ignore the last character and recur for the remaining strings
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    // If the last characters are different, consider all three operations and take the minimum
                    else {
                        dp[i][j] = 1 + Math.min(dp[i][j - 1],Math.min(dp[i - 1][j],dp[i - 1][j - 1]));    
                             // Remove                 // Insert                        // Replace  
                    }
                }
            }
    
            // Return the result from the table
            return dp[m][n];
        }
    
        public static void main(String[] args) {
            EditDistanceDP editDistance = new EditDistanceDP();
            
            String s1 = "cut";
            String s2 = "cat";
            
            int result = editDistance.eD(s1, s2, s1.length(), s2.length());
            System.out.println("Edit Distance between \"" + s1 + "\" and \"" + s2 + "\" is: " + result);
        }
    }

