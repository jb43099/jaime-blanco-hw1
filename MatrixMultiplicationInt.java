import java.util.Random;
import java.util.Arrays;

public class MatrixMultiplicationInt {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[][] matrix1 = generateMatrix(2200, 400);
        int[][] matrix2 = generateMatrix(400, 1850);
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;

        int[][] answerMatrix = MatrixMultiplier(matrix1, matrix2);

        if (cols1 == rows2) {
            System.out.println("Matrix 1:\n" + Arrays.deepToString(matrix1) + "\n");
            System.out.println("Matrix 2:\n" + Arrays.deepToString(matrix2) + "\n");
            System.out.println("Result matrix:\n" + Arrays.deepToString(answerMatrix) +
                    "\n");
        } else {
            System.out.println("Matrices dimensions don't allow for matrix multiplication");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time in milliseconds: " + (endTime - startTime) + "\n");
    }

    // random matrix generator
    public static int[][] generateMatrix(int rows, int cols) {
        Random randomInt = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = randomInt.nextInt(10);
            }
        }
        return matrix;
    }

    // matrix multiplication
    public static int[][] MatrixMultiplier(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        // int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        int[][] resultMatrix = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return resultMatrix;
    }

}