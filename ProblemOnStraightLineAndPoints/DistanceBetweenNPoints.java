import java.util.Scanner;

public class DistanceBetweenNPoints {

    private static int distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
    }

    private static double distanceindouble(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("At least 2 points are required.");
            scanner.close();
            return;
        }

        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        int totalDistance = 0;
        int totalDistanceDouble = 0;
        for (int i = 0; i < n - 1; i++) {
            totalDistance += distance(points[i], points[i + 1]);
            totalDistanceDouble += distanceindouble(points[i], points[i + 1]);
        }

        System.out.println("Total distance between consecutive points: " + totalDistance);
        System.out.println("Total distance (double precision) between consecutive points: " + totalDistanceDouble);
        scanner.close();
    }
}

