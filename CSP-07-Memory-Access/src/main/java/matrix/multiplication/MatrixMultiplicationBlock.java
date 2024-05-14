package matrix.multiplication;

public class MatrixMultiplicationBlock {
    public static void multiplyMatricesBlock(int[][] matrixA, int[][] matrixB, int[][] result, int blockSize) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {

                    for (int ii = i; ii < Math.min(i + blockSize, rowsA); ii++) {
                        for (int jj = j; jj < Math.min(j + blockSize, colsB); jj++) {
                            for (int kk = k; kk < Math.min(k + blockSize, colsA); kk++) {
                                result[ii][jj] += matrixA[ii][kk] * matrixB[kk][jj];
                            }
                        }
                    }
                }
            }
        }
    }
}
