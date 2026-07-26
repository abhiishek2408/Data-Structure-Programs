package ProblemOnStraightLineAndPoints;

public class _27_CheckPerpendicularLines {
    public static boolean arePerpendicular(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // m1 * m2 = -1
        // (y2-y1)/(x2-x1) * (y4-y3)/(x4-x3) = -1
        // (y2-y1)*(y4-y3) == -(x2-x1)*(x4-x3)
        return (long)(y2 - y1) * (y4 - y3) == -(long)(x2 - x1) * (x4 - x3);
    }

    public static void main(String[] args) {
        System.out.println("Are lines perpendicular? " + arePerpendicular(0, 0, 1, 0, 0, 0, 0, 1));
    }
}
