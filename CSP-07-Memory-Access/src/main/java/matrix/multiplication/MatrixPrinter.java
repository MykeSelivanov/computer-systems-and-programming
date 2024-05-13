package matrix.multiplication;

public class MatrixPrinter {
    public static void printMatrix(int[][] matrix, String name) {
        System.out.println("Matrix " + name);
        for (int[] row : matrix) {
            for (int col: row) {
                System.out.println(col + " ");
            }
            System.out.println();
        }
    }
}
