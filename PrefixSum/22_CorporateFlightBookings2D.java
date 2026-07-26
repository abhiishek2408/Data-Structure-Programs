
public class CorporateFlightBookings2D {
    public int[] corpFlightBookings(int[][] bookings, int n) {

    int[] diff = new int[n];

    for(int[] b : bookings){
        int l = b[0] - 1;
        int r = b[1] - 1;
        int seats = b[2];

        diff[l] += seats;

        if(r + 1 < n)
            diff[r+1] -= seats;
    }

    // Build final array
    for(int i = 1; i < n; i++){
        diff[i] += diff[i-1];
    }

    return diff;
}

public static void main(String[] args) {
    CorporateFlightBookings2D solution = new CorporateFlightBookings2D();
    int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
    int n = 5;
    int[] result = solution.corpFlightBookings(bookings, n);
    for (int seats : result) {
        System.out.print(seats + " ");
    }


}

}
