package DynamicProgramming;

public class EggDroppingPuzzleDP {
   

        // Function to get the minimum number of trials needed in the worst case
        public static int eggDrop(int e, int f) {
            // A 2D table where the entry dp[i][j] will represent minimum
            // number of trials needed for i eggs and j floors.
            int[][] dp = new int[e + 1][f + 1];
    
            // Base cases
            // One trial for one floor and zero trials for zero floors
            for (int i = 1; i <= e; i++) {
                dp[i][0] = 0;
                dp[i][1] = 1;
            }
    
            // j trials for one egg and j floors
            for (int j = 1; j <= f; j++) {
                dp[1][j] = j;
            }
    
            // Fill the rest of the entries in the table using optimal substructure property
            for (int i = 2; i <= e; i++) {
                for (int j = 2; j <= f; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = 1; x <= j; x++) {
                        int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                        if (res < dp[i][j]) {
                            dp[i][j] = res;
                        }
                    }
                }
            }
    
            // dp[e][f] holds the result
            return dp[e][f];
        }
    
        public static void main(String[] args) {
            int eggs = 2; // Number of eggs
            int floors = 10; // Number of floors
            System.out.println("Minimum number of trials in worst case: " + eggDrop(eggs, floors));
        }
    }

