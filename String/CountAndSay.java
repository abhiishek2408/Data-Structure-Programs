package String;

class countAndSay {

    public String countAndSayfun(int n) {

        // Base case
        String result = "1";

        // 2 se n tak sequence build karte hain
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            // previous string ko read karo
            for (int j = 1; j < result.length(); j++) {

                // agar same character mila
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } 
                // agar different mila
                else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            // last group ko add karna compulsory hai
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));

            result = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        countAndSay cs = new countAndSay();
        int n = 5; // Example input
        String result = cs.countAndSayfun(n);
        System.out.println("The " + n + "th term in the Count and Say sequence is: " + result);
    }
}

