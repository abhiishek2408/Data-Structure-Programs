package DynamicProgramming;
//Problem: Frog Jump Medium
//You are given a 0-indexed integer array stones sorted in strictly increasing order representing 
// the positions of stones in a river. A frog, initially on the first stone, wants to travel to the 
// last stone and then return to the first stone. However, it can jump to any stone at most once.
// The length of a jump is the absolute difference between the position of the stone the frog is 
// currently on and the position of the stone to which the frog jumps.
//More formally, if the frog is at stones[i] and is jumping to stones[j], the length of the jump is |stones[i] - stones[j]|.
//The cost of a path is the maximum length of a jump among all jumps in the path.
//Return the minimum cost of a path for the frog.

public class FrogJumpMedium {
    
    public int maxJump(int[] stones) {
        int n = stones.length;

        // 🔥 Edge case
        if (n == 2) {
            return stones[1] - stones[0];
        }

        int maxJump = 0;

        for (int i = 2; i < n; i++) {
            maxJump = Math.max(maxJump, stones[i] - stones[i - 2]); // jump from i-2 to i, because we can skip one stone in between to minimize the maximum jump
        }

        return maxJump;
    }

    public static void main(String[] args) {
        FrogJumpMedium frogJumpMedium = new FrogJumpMedium();
        int[] stones = {0, 1, 3, 5, 6};
        int result = frogJumpMedium.maxJump(stones);
        System.out.println("Maximum jump distance for the frog: " + result);
    }
}

/*
dry run:
stones = [0, 1, 3, 5, 6]
n = 5
maxJump = 0
i = 2: maxJump = max(0, 3 - 0) = 3  // jump from 0 to 3
i = 3: maxJump = max(3, 5 - 1) = 4  // jump from 1 to 5
i = 4: maxJump = max(4, 6 - 3) = 4  // jump from 3 to 6
return maxJump = 4

*/



