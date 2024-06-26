package matrix.multiplication;

public class MultiplicationDemoRunner {

    public static final int VALUE_RANGE = 9;
    public static final int BLOCK_SIZE = 1;
    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        int l = 2;

        int[][] m1 = MatrixGenerator.generateMatrixWithRandomNumbers(n, m, VALUE_RANGE);
        int[][] m2 = MatrixGenerator.generateMatrixWithRandomNumbers(m, l, VALUE_RANGE);

        int[][] resultBruteForce = new int[n][l];
        MatrixMultiplicator.multiplyMatricesBruteForce(m1, m2, resultBruteForce);

        MatrixPrinter.printMatrix(m1, "Matrix1");
        MatrixPrinter.printMatrix(m2, "Matrix2");
        MatrixPrinter.printMatrix(resultBruteForce, "Brute force multiplication Result");

        int[][] m2Transposed = MatrixTransposer.transposeMatrix(m2);

        int[][] resultTransposed = new int[n][l];
        MatrixMultiplicator.multiplyMatricesTranspose(m1, m2Transposed, resultTransposed);

        int[][] resultBlock = new int[n][l];
        MatrixMultiplicator.multiplyMatricesBlock(m1, m2, resultBlock, BLOCK_SIZE);

        int[][] resultTransposeBlock = new int[n][l];
        MatrixMultiplicator.multiplyMatricesTransposeBlock(m1, m2Transposed, resultTransposeBlock, BLOCK_SIZE);

        MatrixEqualityComparator.assertEquality(resultBruteForce, "Result brute force", resultTransposed, "Result transpose");
        MatrixEqualityComparator.assertEquality(resultBruteForce, "Result brute force", resultBlock, "Result block");
        MatrixEqualityComparator.assertEquality(resultBruteForce, "Result brute force", resultTransposeBlock, "Result transpose block");

    }
}
