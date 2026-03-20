import java.util.Scanner;

public class CheckRightAngledTriangle {
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

        int a2 = distSq(x1, y1, x2, y2);
        int b2 = distSq(x2, y2, x3, y3);
        int c2 = distSq(x3, y3, x1, y1);

        if (isRightAngled(a2, b2, c2)) {
            System.out.println("The triangle is right-angled.");
        } else {
            System.out.println("The triangle is not right-angled.");
        }
    }

    private static int distSq(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }

    private static boolean isRightAngled(int a2, int b2, int c2) {
        return a2 + b2 == c2 || a2 + c2 == b2 || b2 + c2 == a2;
    }
}
