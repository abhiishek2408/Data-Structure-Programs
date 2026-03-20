// NumWaterBottles.java
// Problem: Water Bottles Exchange

public class NumWaterBottles {
    /**
     * Calculates the total number of water bottles you can drink given the exchange rate.
     * @param numBottles Initial number of full bottles
     * @param numExchange Number of empty bottles required to exchange for a full bottle
     * @return Total number of bottles drunk
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange;
            totalDrunk += newBottles;
            empty = newBottles + (empty % numExchange);
        }

        return totalDrunk;
    }

    // Example usage
    public static void main(String[] args) {
        NumWaterBottles solution = new NumWaterBottles();
        int numBottles = 9, numExchange = 3;
        int result = solution.numWaterBottles(numBottles, numExchange);
        System.out.println("Total bottles drunk: " + result);
    }
}
