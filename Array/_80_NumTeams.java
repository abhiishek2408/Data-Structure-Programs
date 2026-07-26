package Array;

public class _80_NumTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int j = 0; j < n; j++) {

            int leftSmaller = 0, leftGreater = 0;
            int rightSmaller = 0, rightGreater = 0;

            // left side
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) leftSmaller++;
                if (rating[i] > rating[j]) leftGreater++;
            }

            // right side
            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) rightGreater++;
                if (rating[k] < rating[j]) rightSmaller++;
            }

            // increasing + decreasing
            count += leftSmaller * rightGreater;
            count += leftGreater * rightSmaller;
        }

        return count;
    }

    public static void main(String[] args) {
        _80_NumTeams solution = new _80_NumTeams();
        int[] rating = {2, 5, 3, 4, 1};
        int result = solution.numTeams(rating);
        System.out.println("Number of valid teams: " + result);
    }
}

