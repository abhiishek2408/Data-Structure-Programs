import java.util.Scanner;

public class AreaOfTriangleCoordinates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1 and y1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.print("Enter x2 and y2: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        System.out.print("Enter x3 and y3: ");
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        scanner.close();

        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        System.out.println("Area of the triangle: " + area);
    }
}
