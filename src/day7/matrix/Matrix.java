package day7.matrix;

import java.util.Arrays;

public class Matrix {

    private int[][] matrix;

    Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    Matrix addOfMatrices(Matrix anotherMatrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                result[i][j] = this.matrix[i][j] + anotherMatrix.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    Matrix subtractionOfMatrices(Matrix anotherMatrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                result[i][j] = this.matrix[i][j] - anotherMatrix.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    Matrix multiplicationOfMatrices(Matrix anotherMatrix) {
        int[][] result = new int[matrix.length][anotherMatrix.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < anotherMatrix.matrix[0].length; j++) {
                for (int k = 0; k < this.matrix.length; k++) {
                    result[i][j] += this.matrix[i][k] * anotherMatrix.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    Matrix transposeOfMatrix() {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i <this.matrix.length ; i++) {
            for (int j = 0; j <this.matrix.length ; j++) {
                result[i][j] = this.matrix[j][i];
            }
        }
        return new Matrix(result);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.deepEquals(matrix, matrix1.matrix);
    }
}

