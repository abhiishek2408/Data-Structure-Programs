
public class CanPlaceFlowers {
    // Returns true if n flowers can be placed in the flowerbed without violating the no-adjacent-flowers rule
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        for (int i = 0; i < flowerbed.length; i++) {
            
            if (flowerbed[i] == 0) {

                boolean leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1; // flower laga diya
                    n--;

                    if (n == 0) return true;
                }
            }
        }
        return false;
    }

    // Example usage
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println("Can place " + n + " flowers: " + canPlaceFlowers(flowerbed, n));
        n = 2;
        int[] flowerbed2 = {1, 0, 0, 0, 1};
        System.out.println("Can place " + n + " flowers: " + canPlaceFlowers(flowerbed2, n));
    }
}
