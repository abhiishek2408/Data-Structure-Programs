package Array;
import java.util.*;

public class _27_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) res.add(matrix[rowStart][j]);
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) res.add(matrix[i][colEnd]);
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) res.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) res.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
}
