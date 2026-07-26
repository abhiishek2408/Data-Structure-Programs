public class ShiftingLetters2D {
    public String shiftingLetters(String s, int[][] shifts) {

    int n = s.length();
    int[] diff = new int[n + 1];

    for(int[] sh : shifts){
        int l = sh[0];
        int r = sh[1];
        int dir = sh[2] == 1 ? 1 : -1;

        diff[l] += dir;

        if(r + 1 < n)
            diff[r+1] -= dir;
    }

    // Prefix sum
    for(int i = 1; i < n; i++){
        diff[i] += diff[i-1];
    }

    char[] res = s.toCharArray();

    for(int i = 0; i < n; i++){
        int shift = diff[i] % 26;

        int newChar = (res[i] - 'a' + shift + 26) % 26;

        res[i] = (char)(newChar + 'a');
    }

    return new String(res);
}

public static void main(String[] args) {
    ShiftingLetters2D solution = new ShiftingLetters2D();
    String s = "abc";
    int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
    System.out.println(solution.shiftingLetters(s, shifts)); // Output: "ace"
}

}