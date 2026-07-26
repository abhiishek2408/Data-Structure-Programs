package ProblemOnStraightLineAndPoints;

public class _28_EquationOfLine {
    public static void printEquation(int x1, int y1, int x2, int y2) {
        // (y - y1) = m(x - x1)
        // (y - y1) = (y2 - y1)/(x2 - x1) * (x - x1)
        // (x2 - x1)(y - y1) = (y2 - y1)(x - x1)
        // (x2 - x1)y - (x2 - x1)y1 = (y2 - y1)x - (y2 - y1)x1
        // (y1 - y2)x + (x2 - x1)y + (y2*x1 - y1*x2) = 0
        
        int a = y1 - y2;
        int b = x2 - x1;
        int c = y2 * x1 - y1 * x2;
        
        System.out.println("Equation: " + a + "x + " + b + "y + " + c + " = 0");
    }

    public static void main(String[] args) {
        printEquation(1, 2, 3, 4);
    }
}
