import java.util.Scanner;

public class CountLatticePointsInsideCircle {
    
    public static int countLatticePoints(int cx, int cy, int r) {
        int r2 = r * r;
        int count = 0;
        for (int x = cx - r; x <= cx + r; x++) {
            for (int y = cy - r; y <= cy + r; y++) {
                int dx = x - cx;
                int dy = y - cy;
                if (dx * dx + dy * dy <= r2) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter center x and y of circle: ");
        int cx = scanner.nextInt();
        int cy = scanner.nextInt();
        System.out.print("Enter radius of circle: ");
        int r = scanner.nextInt();
        scanner.close();
        int count = countLatticePoints(cx, cy, r);
        System.out.println("Number of lattice points inside or on the circle: " + count);
    }

}
