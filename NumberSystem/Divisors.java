import java.util.*;

public class Divisors {

    public static void naivemethod(int n) {
      for(int i = 1; i <= n; i++){
        if(n % i == 0){
          System.out.print(i + " ");
    }
   }
    }

    public static void printDivisors(int n) {

        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                small.add(i);

                if (i != n / i) {
                    large.add(n / i);
                }
            }
        }

        // Print in sorted order
        for (int x : small) {
            System.out.print(x + " ");
        }

        for (int i = large.size() - 1; i >= 0; i--) {
            System.out.print(large.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        int n = 36;
        printDivisors(n);
    }
}
