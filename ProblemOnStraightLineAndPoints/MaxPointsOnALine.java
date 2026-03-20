import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int same = 1;
            int localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    same++;
                } else {
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    String slope = dx + "/" + dy;
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                    localMax = Math.max(localMax, slopeCount.get(slope));
                }
            }
            max = Math.max(max, localMax + same);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPointsOnALine mpl = new MaxPointsOnALine();
        int[][] points = { {1,1}, {2,2}, {3,3}, {4,5} };
        System.out.println(mpl.maxPoints(points)); // Output: 3
    }
}
