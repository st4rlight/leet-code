package cn.st4rlight.solution.array.prefix;

/**
 * 与304类型，都是前缀思想，不过303是数组，304是链表
 * 同样，最好预留0号位座位dummy node
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class _304 {

    class NumMatrix {

        public int[][] preMatrix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null) {
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;
            preMatrix = new int[rows + 1][cols + 1];
            for (int i = 0; i < cols; i++) {
                preMatrix[0][i] = 0;
            }
            for (int i = 0; i < rows; i++) {
                preMatrix[i][0] = 0;
            }


            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    preMatrix[i][j] = preMatrix[i - 1][j]
                            + preMatrix[i][j - 1]
                            - preMatrix[i - 1][j - 1]
                            + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preMatrix[row2 + 1][col2 + 1]
                    - preMatrix[row2 + 1][col1]
                    - preMatrix[row1][col2 + 1]
                    + preMatrix[row1][col1];
        }
    }
}
