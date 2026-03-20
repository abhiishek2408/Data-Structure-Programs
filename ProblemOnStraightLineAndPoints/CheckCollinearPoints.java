import java.util.Scanner;

public class CheckCollinearPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] points = new int[3][2];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        scanner.close();
        if (areCollinear(points[0], points[1], points[2])) {
            System.out.println("The points are collinear.");
        } else {
            System.out.println("The points are not collinear.");
        }
    }

    // Using area of triangle method
    private static boolean areCollinear(int[] p1, int[] p2, int[] p3) {
        int area = p1[0] * (p2[1] - p3[1]) +
                   p2[0] * (p3[1] - p1[1]) +
                   p3[0] * (p1[1] - p2[1]);
        return area == 0;
    }
}
