import java.util.Random;

/**
 * Created by chen on 15/4/6.
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 * <p/>
 * Tips:
 * Use two array to mark which row and which col should be reset to zero perspectively.
 * <p/>
 * Notes: none
 * <p/>
 * Time complexity: O(M*N)
 * Space complexity: O(M+N)
 * <p/>
 * Improvement: we could use the first row and first col to mark which row and which col
 * should be reset to zero, then the space complexity will be O(1)
 */
public class CC150_1_7 {

    private static int[][] resetMatrix(int[][] matrix) {
        int[] row = new int[matrix.length];    //mark if the row should be reset to 0
        int[] col = new int[matrix[0].length];   //mark if the column should be reset to 0

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    private static int[][] resetMatrix2(int[][] matrix) {
        boolean colFlag = false;
        boolean rowFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }

        if (rowFlag) {
            for (int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] m1 = new int[9][10];
        int[][] m2 = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                m1[i][j] = 1;
                m2[i][j] = 1;
            }
        }

        m1[2][1] = 0;
        m1[4][4] = 0;
        m1[8][6] = 0;
        m1[0][4] = 0;

        m2[2][1] = 0;
        m2[4][4] = 0;
        m2[8][6] = 0;
        m2[0][4] = 0;

        m1 = resetMatrix(m1);
        m2 = resetMatrix2(m2);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
