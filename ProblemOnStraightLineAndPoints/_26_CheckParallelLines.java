package ProblemOnStraightLineAndPoints;

public class _26_CheckParallelLines {
    public static boolean areParallel(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // m1 = (y2-y1)/(x2-x1)
        // m2 = (y4-y3)/(x4-x3)
        // Parallel if m1 == m2 => (y2-y1)*(x4-x3) == (y4-y3)*(x2-x1)
        return (long)(y2 - y1) * (x4 - x3) == (long)(y4 - y3) * (x2 - x1);
    }

    public static void main(String[] args) {
        System.out.println("Are lines parallel? " + areParallel(0, 0, 1, 1, 1, 0, 2, 1));
    }
}
