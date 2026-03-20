import java.util.*;
// K Closest Points to Origin
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
// return the k closest points to the origin (0, 0).
/*
Test case:
Input: points = [[1,3],[-2,2],[2,-2]], k = 2
Output: [[-2,2],[2,-2]]
explanation: The distance between each point and the origin is as follows:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
The distance between (2, -2) and the origin is sqrt(8).
*/

public class KClosestPointsToOrigin {

    private static int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> Integer.compare( distanceSquared(a), distanceSquared(b)));
        return Arrays.copyOfRange(points, 0, k);
    }

    public static int[][] kClosestPriorityQueue(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distanceSquared(b), distanceSquared(a))
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
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
        System.out.print("Enter k: ");
        int k = scanner.nextInt();
        scanner.close();

        int[][] closest = kClosest(points, k);
        System.out.println("K closest points to origin:");
        for (int[] p : closest) {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }


}
