package Ovinger.Oving6.Oving64;

import java.util.Arrays;

public class Matrix {

    private int[][] matrix;

    private int m;
    private int n;

    private int[][] matrixAdd;
    private int[][] matrixMult;
    private int[][] matrixTrans;

    public Matrix(int[][] matrix1){
        this.matrix = matrix1;
        m = matrix1.length;
        n = matrix1[0].length;
    }

    public int[][] addMatrices(int[][] matrix2, int m2, int n2){
        if(m == m2 && n == n2){
            matrixAdd = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){

                for(int y = 0; y < matrix[0].length; y++) {
                    matrixAdd[i][y] = matrix[i][y] + matrix2[i][y];
                }

            }
        }else{
            System.out.println("Can't add the matrices, because they are not the same dimensions");
            matrixAdd = null;
        }

        return matrixAdd;
    }

    public int[][] getMatrixAdd() {
        return matrixAdd;
    }

    public int[][] multiplyMatrices(int[][] matrix2, int m2, int n2){
        if(m2 == n){
            this.matrixMult = new int[m][n2];
            for(int i = 0; i < matrix.length; i++){

                for(int y = 0; y < matrix2[0].length; y++){

                    for(int k = 0; k < matrix[0].length; k++) {
                        this.matrixMult[i][y] += matrix[i][k] * matrix2[k][y];
                    }
                }
            }
        }else{
            System.out.println("Can't multiply matrices when n1 != m2");
            this.matrixMult = null;
        }
        return matrixMult;
    }

    public int[][] transposeMatrix(){
        this.matrixTrans = new int[matrix[0].length][matrix.length];


        for(int i = 0; i < matrix.length; i++){
            for(int y = 0; y < matrix[0].length; y++){
                this.matrixTrans[y][i] = matrix[i][y];
            }
        }
        return matrixTrans;
    }

    public int[][] getMatrixTrans() {
        return matrixTrans;
    }

    public int[][] getMatrixMult() {
        return matrixMult;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.deepToString(matrix) +
                ", m=" + m +
                ", n=" + n +
                ", matrixAdd=" + Arrays.deepToString(matrixAdd) +
                ", matrixMult=" + Arrays.deepToString(matrixMult) +
                ", matrixTrans=" + Arrays.deepToString(matrixTrans) +
                '}';
    }
}
