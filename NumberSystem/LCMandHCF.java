// LCM and HCF calculation for two numbers
public class LCMandHCF {
    // Calculate HCF (GCD) using Euclidean algorithm
    public static int hcf(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //recursive method to calculate HCF
    public static int hcfRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return hcfRecursive(b, a % b);
    }

    // Calculate LCM using HCF
    public static int lcm(int a, int b) {
        return (a * b) / hcf(a, b);
    }

    // Example usage
    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 18;
        System.out.println("HCF of " + num1 + " and " + num2 + " is: " + hcf(num1, num2));
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm(num1, num2));
    }
}
