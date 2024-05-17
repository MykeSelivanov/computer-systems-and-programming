package matrix.multiplication;
public class MatrixMultiplicationSpeedTest {
    public static final int BLOCK_SIZE = 100;
    public static final int WARMUP_COUNT = 1;
    public static final int ITERATION_COUNT = 5;
    public static final int TIME_FACTOR = 100000;
    public static final int VALUE_RANGE = 100;

    public static void main(String[] args) {
        int n = 5000;
        int m = 2000;
        int l = 5000;

        int[][] m1 = MatrixGenerator.generateMatrixWithRandomNumbers(n, m, VALUE_RANGE);
        int[][] m2 = MatrixGenerator.generateMatrixWithRandomNumbers(m, l, VALUE_RANGE);

        int[][] resultBruteForce = new int[n][l];
        int[][] m2Transposed = MatrixTransposer.transposeMatrix(m2);
        int[][] resultTransposed = new int[n][l];
        int[][] resultBlock = new int[n][l];
        int[][] resultTransposeBlock = new int[n][l];

        long durationBruteForce = averageExecutionTime(() -> MatrixMultiplicator.multiplyMatricesBruteForce(m1, m2, resultBruteForce), ITERATION_COUNT);
        System.out.println("Execution time of brute force multiplication: " + durationBruteForce / TIME_FACTOR + " ms");

        long durationTransposed = averageExecutionTime(() -> MatrixMultiplicator.multiplyMatricesTranspose(m1, m2Transposed, resultTransposed), ITERATION_COUNT);
        System.out.println("Execution time of transposed multiplication: " + durationTransposed / TIME_FACTOR + " ms");

        long durationBlock = averageExecutionTime(() -> MatrixMultiplicator.multiplyMatricesBlock(m1, m2, resultBlock, BLOCK_SIZE), ITERATION_COUNT);
        System.out.println("Execution time of block multiplication: " + durationBlock / TIME_FACTOR + " ms");

        long durationTransposeBlock = averageExecutionTime(() -> MatrixMultiplicator.multiplyMatricesTransposeBlock(m1, m2, resultTransposeBlock, BLOCK_SIZE), ITERATION_COUNT);
        System.out.println("Execution time of transposed block multiplication: " + durationTransposeBlock / TIME_FACTOR + " ms");
    }
    public static long averageExecutionTime(Runnable method, int iterations) {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            method.run();
        }
        long totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            method.run();
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        return totalTime / iterations;
    }
}
