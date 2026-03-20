package Array;

class RemoveZeroesFromNumber {
    public long removeZeros(long n) {
        long temp = 0;

        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
                temp = temp * 10 + digit;
            }
            n /= 10;
        }

        // reverse again to correct order
        long result = 0;
        while (temp > 0) {
            result = result * 10 + temp % 10;
            temp /= 10;
        }

        return result;
    }
}
