package matrix.multiplication;

public class MatrixMultiplicationTransposeBlock {
    public static void multiplyMatricesTransposeBlock(int[][] matrixA, int[][] transposedMatrixB, int[] result, int blockSize) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = transposedMatrixB.length; // now rows of matrixB, since it was transposed

        for (int i = 0; i < rowsA; i += blockSize) {
            for (int j = 0; j < rowsB; j += blockSize) {
                for (int k = 0; k < colsA; k += blockSize) {


                }
            }
        }
    }
}
