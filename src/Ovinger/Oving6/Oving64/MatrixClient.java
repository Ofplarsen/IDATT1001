package Ovinger.Oving6.Oving64;

import java.util.Arrays;

public class MatrixClient {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {2, 3, 4, 6},
                {3, 2, 7, 7},
                {2, 3, 9, 4},
                {4, 2, 3, 4}
        };

        int[][] matrix2 = {
                {2, 3, 5},
                {9, 2, 3},
                {7, 3, 1},
                {10, 3, 4}
        };

        Matrix testMatrix = new Matrix(matrix1);
        Matrix testMatrix2 = new Matrix(matrix2);

        System.out.println( "Adding the matrices: "+ Arrays.deepToString(testMatrix.addMatrices(testMatrix2.getMatrix(), testMatrix2.getM(), testMatrix2.getN())));
        System.out.println("Multiplying the matrices: " + Arrays.deepToString(testMatrix.multiplyMatrices(testMatrix2.getMatrix(), testMatrix2.getM(), testMatrix2.getN())));
        System.out.println("The matrix transposed: " + Arrays.deepToString(testMatrix.transposeMatrix()));

        System.out.println(testMatrix.toString());
        System.out.println(testMatrix2.toString());
    }
}
