package DynamicProgramming;

public class EggDroppingPuzzle {

    // Recursive function to get the minimum number of trials needed in the worst case
    public static int eggDrop(int e, int f) {
        // Base cases
        if (f == 0 || f == 1) {
            return f;
        }
        if (e == 1) {
            return f;
        }

        int minTrials = Integer.MAX_VALUE;

        // Consider dropping an egg from each floor and calculate the minimum trials
        for (int x = 1; x <= f; x++) {
            int trials = 1 + Math.max(eggDrop(e - 1, x - 1), eggDrop(e, f - x));
            minTrials = Math.min(minTrials, trials);
        }

        return minTrials;
    }

    public static void main(String[] args) {
        int eggs = 2; // Number of eggs
        int floors = 10; // Number of floors
        System.out.println("Minimum number of trials in worst case: " + eggDrop(eggs, floors));
    }
}