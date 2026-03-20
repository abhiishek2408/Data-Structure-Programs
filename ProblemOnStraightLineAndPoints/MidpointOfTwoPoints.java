import java.util.Scanner;

public class MidpointOfTwoPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1 and y1: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.print("Enter x2 and y2: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        scanner.close();

        double midX = (x1 + x2) / 2.0;
        double midY = (y1 + y2) / 2.0;

        System.out.println("Midpoint: (" + midX + ", " + midY + ")");
    }
}
