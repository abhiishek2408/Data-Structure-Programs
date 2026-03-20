// ReverseBits.java
// Reverses the bits of an integer
/*
Test case:
Input: n = 13 (binary: 1101)
Output: 11 (binary: 1011)
*/

class ReverseBits {

    // Reverse the bits of an integer (for 32 bits)
    static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            rev |= (n & 1); 
            n >>= 1;
        }
        return rev;
    }

    // Reverse the bits of an integer for a given number of bits
    static int reverseBits(int n, int bits) {
        int rev = 0;
        for (int i = 0; i < bits; i++) {
            rev <<= 1;
            rev |= (n & 1);
            n >>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        int n = 13; // binary: 1101
        int bits = 4;
        int reversed = reverseBits(n, bits);
        System.out.println("Reversed bits (4 bits): " + reversed); // Output: 11 (1011)
    }
}
