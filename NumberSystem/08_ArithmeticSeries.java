public class ArithmeticSeries {

    public static int sumAP(int a, int d, int n) {
        return n * (2 * a + (n - 1) * d) / 2;
    }

    public static void main(String[] args) {

        int a = 2, d = 3, n = 5;

        System.out.println("Sum = " + sumAP(a, d, n));
    }
}
