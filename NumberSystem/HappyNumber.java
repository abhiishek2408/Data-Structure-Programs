class HappyNumber {
    public boolean isHappy(int n) {
        int dig;
        int num = 0;
        boolean ishappy = false;

        while (n != 1 && n != 4) {
            num = 0;
            while (n > 0) {
                dig = n % 10;
                num += (dig * dig);
                n = n / 10;
            }
            n = num;
        }

        if (n == 1) {
            ishappy = true;
        } else {
            ishappy = false;
        }

        return ishappy;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        int testNumber = 19; // Example number to test
        if (happyNumber.isHappy(testNumber)) {
            System.out.println(testNumber + " is a happy number.");
        } else {
            System.out.println(testNumber + " is not a happy number.");
        }
    }
}
