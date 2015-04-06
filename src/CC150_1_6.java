/**
 * Created by chen on 15/4/6.
 * 1.6 Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 * <p/>
 * Tips:
 * for row = i, column = j (0 <= i < N, 0 <= j < N),
 * (i , j) -> (j, N - 1 - i) -> (N - 1 - i, N - 1 - j) -> (N - 1 - j, i) -> (i, j)
 * <p/>
 * Notes: the key point of this question is clearing the rotate sequence
 * <p/>
 * Time complexity: O(N^2) - as we used two loops
 * Space Complexity: O(1) - as in place, we don't need additional array
 */
public class CC150_1_6 {

    private static int[][] rotateMatrix(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i <= N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
