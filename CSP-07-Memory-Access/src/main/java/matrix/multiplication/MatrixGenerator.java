package matrix.multiplication;

import java.util.Random;

public class MatrixGenerator {
    public static int[][] generateMatrixWithRandomNumbers(int rows, int columns, int valueRange) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(valueRange);
            }
        }
        return matrix;
    }
}
