import java.util.Scanner;

public class CountPointsInsideCircle {

    public static int countInside(int[][] points, int cx, int cy, int r) {
        int r2 = r * r;
        int count = 0;
        for (int[] p : points) {
            int dx = p[0] - cx;
            int dy = p[1] - cy;
            if (dx * dx + dy * dy < r2) {
                count++;
            }
        }
        return count;
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
        System.out.print("Enter center x and y of circle: ");
        int cx = scanner.nextInt();
        int cy = scanner.nextInt();
        System.out.print("Enter radius of circle: ");
        int r = scanner.nextInt();
        scanner.close();
        int count = countInside(points, cx, cy, r);
        System.out.println("Number of points inside the circle: " + count);
    }

}
