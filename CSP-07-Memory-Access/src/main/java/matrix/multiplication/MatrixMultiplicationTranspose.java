package matrix.multiplication;

public class MatrixMultiplicationTranspose {
    public static void multiplyMatricesTranspose(int[][] matrixA, int[][] transposedMatrixB, int[][] result) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = transposedMatrixB.length;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < rowsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * transposedMatrixB[j][k];
                }
            }
        }

    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
