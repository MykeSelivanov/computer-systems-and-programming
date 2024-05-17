package matrix.multiplication;

public class MatrixMultiplicator {
    public static void multiplyMatricesBruteForce(int[][] matrixA, int[][] matrixB, int[][] result) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
    }

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

    public static void multiplyMatricesBlock(int[][] matrixA, int[][] matrixB, int[][] result, int blockSize) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        for (int i = 0; i < rowsA; i += blockSize) {
            for (int j = 0; j < colsB; j += blockSize) {
                for (int k = 0; k < colsA; k += blockSize) {

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

    public static void multiplyMatricesTransposeBlock(int[][] matrixA, int[][] transposedMatrixB, int[][] result, int blockSize) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = transposedMatrixB.length; // now rows of matrixB, since it was transposed

        for (int i = 0; i < rowsA; i += blockSize) {
            for (int j = 0; j < rowsB; j += blockSize) {
                for (int k = 0; k < colsA; k += blockSize) {

                    for (int ii = i; ii < Math.min(i + blockSize, rowsA); ii++) {
                        for (int jj = j; jj < Math.min(j + blockSize, rowsB); jj++) {
                            for (int kk = k; kk < Math.min(k + blockSize, colsA); kk++) {
                                result[ii][jj] += matrixA[ii][kk] * transposedMatrixB[jj][kk];
                            }
                        }
                    }
                }
            }
        }
    }
}
