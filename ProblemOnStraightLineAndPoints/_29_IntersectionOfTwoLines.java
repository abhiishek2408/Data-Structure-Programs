package ProblemOnStraightLineAndPoints;

public class _29_IntersectionOfTwoLines {
    public static void findIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // Line 1: a1x + b1y = c1
        // Line 2: a2x + b2y = c2
        
        long a1 = y1 - y2;
        long b1 = x2 - x1;
        long c1 = a1 * x1 + b1 * y1;
        
        long a2 = y3 - y4;
        long b2 = x4 - x3;
        long c2 = a2 * x3 + b2 * y3;
        
        long det = a1 * b2 - a2 * b1;
        
        if (det == 0) {
            System.out.println("Lines are parallel, no unique intersection.");
        } else {
            double x = (double)(b2 * c1 - b1 * c2) / det;
            double y = (double)(a1 * c2 - a2 * c1) / det;
            System.out.println("Intersection: (" + x + ", " + y + ")");
        }
    }

    public static void main(String[] args) {
        findIntersection(0, 0, 4, 4, 0, 4, 4, 0);
    }
}
