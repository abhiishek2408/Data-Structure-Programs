public class CountRectangless {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] result = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int px = points[i][0], py = points[i][1];
            int count = 0;
            for (int[] rect : rectangles) {
                int rx = rect[0], ry = rect[1];
                // Rectangle is from (0,0) to (rx,ry)
                if (px <= rx && py <= ry) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}
