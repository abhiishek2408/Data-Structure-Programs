
import java.util.ArrayList;
import java.util.Collections;

public class CountRectangles {
    @SuppressWarnings("unchecked")
        // Highly efficient version using y buckets and binary search on x
        public int[] countRectanglesEfficient(int[][] rectangles, int[][] points) {
            // y ranges from 1 to 100 (problem constraint)
            ArrayList<Integer>[] buckets = new ArrayList[101];
            
            for (int i = 1; i <= 100; i++) buckets[i] = new ArrayList<>();
            for (int[] rect : rectangles) {
                buckets[rect[1]].add(rect[0]);
            }
            // Sort each bucket
            for (int i = 1; i <= 100; i++) {
                Collections.sort(buckets[i]);
            }
            int[] result = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                int px = points[i][0], py = points[i][1];
                int count = 0;
                for (int y = py; y <= 100; y++) {
                    ArrayList<Integer> xs = buckets[y];
                    // Binary search for first x >= px
                    int l = 0, r = xs.size();
                    while (l < r) {
                        int m = (l + r) / 2;
                        if (xs.isEmpty() || xs.get(m) < px) l = m + 1;
                        else r = m;
                    }
                    count += xs.size() - l;
                }
                result[i] = count;
            }
            return result;
        }
        
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int px = points[i][0];
            int py = points[i][1];
            int count = 0;
            for (int[] rect : rectangles) {
                int rx = rect[0];
                int ry = rect[1];
                // Rectangle is from (0,0) to (rx,ry)
                if (px <= rx && py <= ry) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        CountRectangles cr = new CountRectangles();
        int[][] rectangles = { {1, 2}, {2, 3}, {3, 4} };
        int[][] points = { {1, 1}, {2, 2}, {3, 3} };
        System.out.println("Highly efficient version:");
        int[] resultEff = cr.countRectanglesEfficient(rectangles, points);
        for (int count : resultEff) {
            System.out.println(count);
        }
        System.out.println("Brute force version:");
        int[] resultBrute = cr.countRectangles(rectangles, points);
        for (int count : resultBrute) {
            System.out.println(count);
        }
    }
}
