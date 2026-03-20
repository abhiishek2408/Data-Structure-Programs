package Array;

import java.util.Arrays;

class NonOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int remove = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap → remove current interval
                remove++;
            } else {
                // No overlap → update end
                prevEnd = intervals[i][1];
            }
        }
        return remove;
    }


    public static void main(String[] args) {
        NonOverlapIntervals sol = new NonOverlapIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int res = sol.eraseOverlapIntervals(intervals);
        System.out.println("Minimum number of intervals to remove: " + res);
    }
}
