public class MaximumPopulationYear2D {
    public int maximumPopulation(int[][] logs) {

    int[] diff = new int[101]; // 1950–2050

    for(int[] log : logs){
        int birth = log[0] - 1950;
        int death = log[1] - 1950;

        diff[birth] += 1;
        diff[death] -= 1;
    }

    int maxPop = 0;
    int year = 1950;
    int curr = 0;

    for(int i = 0; i < 101; i++){
        curr += diff[i];

        if(curr > maxPop){
            maxPop = curr;
            year = 1950 + i;
        }
    }

    return year;
}

public static void main(String[] args) {
    MaximumPopulationYear2D solution = new MaximumPopulationYear2D();
    int[][] logs = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
    System.out.println(solution.maximumPopulation(logs)); // Output: 1960

}
}