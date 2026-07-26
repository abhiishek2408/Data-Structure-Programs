public class GasStationProblem {
    public int canCompleteCircuit(int[] gas, int[] cost) {

    int total = 0;
    int tank = 0;
    int start = 0;

    for(int i = 0; i < gas.length; i++){

        int diff = gas[i] - cost[i];

        total += diff;
        tank += diff;

        if(tank < 0){
            start = i + 1;
            tank = 0;
        }
    }

    return total >= 0 ? start : -1;
}

public static void main(String[] args) {
    GasStationProblem solution = new GasStationProblem();
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost = {3, 4, 5, 1, 2};
    System.out.println(solution.canCompleteCircuit(gas, cost)); // Output: 3
}

}