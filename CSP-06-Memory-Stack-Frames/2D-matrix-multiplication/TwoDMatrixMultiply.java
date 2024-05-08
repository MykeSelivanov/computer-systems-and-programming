public class TwoDMatrixMultiply {

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        System.out.println("\nMatrix 1:");
        printMatrix(matrix1);
        System.out.println("\nMatrix 2:");
        printMatrix(matrix2);

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            System.out.println("To multiply matrices, matrix1 columns should be equal to the number of the matrix2 rows");
            return null;
        }

        int[][] result = new int[rows1][cols2];
        
        // multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < rows2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("\nResultant Matrix:");
        printMatrix(result);

        return result;
    }

    public static void printMatrix(int matrix[][]) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
    }


    public static void main(String[] args) {
        // int[][] matrixA = {
        //         { 1, 2, 3 },
        //         { 4, 5, 6 },
        //         { 7, 8, 9 }
        // };
        // int[][] matrixB = {
        //         { 10, 11 },
        //         { 12, 13 },
        //         { 14, 15 }
        // };
        int[][] matrixA = {
                { 1, 2},
                { 3, 4},
        };
        int[][] matrixB = {
                { 5, 6 },
                { 7, 8 },
        };

        multiplyMatrices(matrixA, matrixB);
    }
    
}
