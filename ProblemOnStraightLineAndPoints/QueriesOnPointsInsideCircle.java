import java.util.Scanner;

public class QueriesOnPointsInsideCircle {

    public int[] countPoints(int[][] points, int[][] queries) {
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
        int cx = queries[i][0], cy = queries[i][1], r = queries[i][2];
        int r2 = r * r, count = 0;
        for (int[] p : points) {
            int dx = p[0] - cx, dy = p[1] - cy;
            if (dx * dx + dy * dy <= r2) count++;
        }
        result[i] = count;
    }
    return result;
}

    public static int countInside(int[][] points, int cx, int cy, int r) {
        int r2 = r * r;
        int count = 0;
        for (int[] p : points) {
            int dx = p[0] - cx;
            int dy = p[1] - cy;
            if (dx * dx + dy * dy <= r2) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of points: ");
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }


        System.out.print("Enter number of queries: ");
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            System.out.print("Enter center x, y and radius r for query " + (i + 1) + ": ");
            int cx = scanner.nextInt();
            int cy = scanner.nextInt();
            int r = scanner.nextInt();
            int count = countInside(points, cx, cy, r);
            System.out.println("Query " + (i + 1) + ": " + count + " points inside the circle");
        }
        scanner.close();
    }


}
