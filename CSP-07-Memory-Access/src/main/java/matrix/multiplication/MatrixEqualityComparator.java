package matrix.multiplication;

public class MatrixEqualityComparator {
    public static void assertEquality(int[][] matrixA, String nameMatrixA, int [][] matrixB, String nameMatrixB) {
        if (!areMatricesEqual(matrixA, matrixB)) {
            System.out.println("Assertion failed. Matrices are not equal:");
            MatrixPrinter.printMatrix(matrixA, nameMatrixA);
            MatrixPrinter.printMatrix(matrixB, nameMatrixB);
            throw new IllegalArgumentException("Matrices expected to be equal");
        }
    }

    public static boolean areMatricesEqual(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length) {
            return false;
        }
        for (int i = 0; i < matrixA.length; i++) {
            if (matrixA[i].length != matrixB[i].length) {
                return false;
            }
            for (int j = 0; j < matrixA[i].length; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
