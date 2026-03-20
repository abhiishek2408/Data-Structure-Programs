import java.util.Scanner;

public class ClosestPointToOrigin {

    public static int[] findClosestPointToOrigin(int[][] points) {
        int minDistSq = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++) {
            int distSq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (distSq < minDistSq) {
                minDistSq = distSq;
                minIndex = i;
            }
        }
        return points[minIndex];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        scanner.close();
        int[] closest = findClosestPointToOrigin(points);
        System.out.println("Point closest to origin: (" + closest[0] + ", " + closest[1] + ")");
    }


}
