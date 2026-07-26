public class CarPooling2D {
    
    public boolean carPooling(int[][] trips, int capacity) {

    int[] diff = new int[1001];

    for(int[] t : trips){
        int num = t[0];
        int from = t[1];
        int to = t[2];

        diff[from] += num;
        diff[to] -= num;
    }

    int curr = 0;

    for(int i = 0; i < 1001; i++){
        curr += diff[i];

        if(curr > capacity)
            return false;
    }

    return true;
}

public static void main(String[] args) {
    CarPooling2D solution = new CarPooling2D();
    int[][] trips = {{2, 1, 5}, {3, 3, 7}};
    int capacity = 4;
    System.out.println(solution.carPooling(trips, capacity)); // Output: false
}

}