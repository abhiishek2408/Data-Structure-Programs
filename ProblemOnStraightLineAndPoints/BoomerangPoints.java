// BoomerangPoints.java
// Given a list of points in the plane, return the number of boomerangs.
// A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

import java.util.HashMap;

public class BoomerangPoints {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dist = getDistance(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            System.out.println("Point " + i + " distance map: " + map);
            
            for (int val : map.values()) {
                count += val * (val - 1);
            }
            System.out.println("After point " + i + ", total boomerangs: " + count);
        }
        return count;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    // Example usage
    public static void main(String[] args) {
        BoomerangPoints bp = new BoomerangPoints();
        int[][] points = { {0,0}, {1,0}, {2,0} };
        System.out.println(bp.numberOfBoomerangs(points)); // Output: 2
    }
}
