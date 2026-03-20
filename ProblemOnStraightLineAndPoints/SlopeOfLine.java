import java.util.Scanner;

public class SlopeOfLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1 and y1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.print("Enter x2 and y2: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        scanner.close();
        
        if (x2 == x1) {
            System.out.println("The line is vertical; slope is undefined (infinite).");
        } else {
            double slope = (double)(y2 - y1) / (x2 - x1);
            System.out.println("Slope of the line: " + slope);
        }
    }
}
