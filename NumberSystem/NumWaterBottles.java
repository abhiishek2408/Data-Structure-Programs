// NumWaterBottles.java
// Problem: Water Bottles Exchange
// Given numBottles full water bottles, you can exchange numExchange empty bottles for one full bottle.
// Return the total number of water bottles you can drink.

public class NumWaterBottles {
    /**
     * Calculates the total number of water bottles you can drink given the exchange rate.
     * @param numBottles Initial number of full bottles
     * @param numExchange Number of empty bottles required to exchange for a full bottle
     * @return Total number of bottles drunk
     */
    
public int numWaterBottles(int numBottles, int numExchange) {
    int total = 0;
    int empty = 0;

    while (numBottles > 0) {
        numBottles--;
        total++;
        empty++;

        if (empty == numExchange) {
            numBottles++;
            empty = 0;
        }
    }

    return total;
}

    // Example usage
    public static void main(String[] args) {
        NumWaterBottles solution = new NumWaterBottles();
        int numBottles = 9, numExchange = 3;
        int result = solution.numWaterBottles(numBottles, numExchange);
        System.out.println("Total bottles drunk: " + result);
    }
}
