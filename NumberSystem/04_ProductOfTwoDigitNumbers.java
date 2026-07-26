public class ProductOfTwoDigitNumbers {
    public static void main(String[] args) {
        int N = 2222;
        int firstPart = N / 100; 
        int secondPart = N % 100;

        int product = firstPart * secondPart;

        System.out.println("Output: " + product);
    }
}

