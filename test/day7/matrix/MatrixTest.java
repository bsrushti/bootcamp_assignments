package day7.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void shouldReturnAdditionOfTwoMatrices() {
        SampleMatrices sampleMatrices = new SampleMatrices();
        Matrix matrix = new Matrix(sampleMatrices.getTwoByTwoMatrix());
        Matrix anotherTwoByTwoMatrix = new Matrix(sampleMatrices.getTwoByTwoMatrix());

        int [][]expectedMatrix = new int [2][2];
        expectedMatrix[0][0] = 2;
        expectedMatrix[0][1] = 4;
        expectedMatrix[1][0] = 6;
        expectedMatrix[1][1] = 8;

        Matrix expected = new Matrix(expectedMatrix);
        Matrix actual = matrix.addOfMatrices(anotherTwoByTwoMatrix);
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnSubtractionOfTwoMatrices() {
        SampleMatrices sampleMatrices = new SampleMatrices();
        Matrix matrix = new Matrix(sampleMatrices.getTwoByTwoMatrix());
        Matrix anotherTwoByTwoMatrix = new Matrix(sampleMatrices.getTwoByTwoMatrix());

        int [][]expectedMatrix = new int [2][2];
        expectedMatrix[0][0] = 0;
        expectedMatrix[0][1] = 0;
        expectedMatrix[1][0] = 0;
        expectedMatrix[1][1] = 0;

        Matrix expected = new Matrix(expectedMatrix);
        Matrix actual = matrix.subtractionOfMatrices(anotherTwoByTwoMatrix);
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnMultiplicationOfTwoMatrices() {
        SampleMatrices sampleMatrices = new SampleMatrices();
        Matrix matrix = new Matrix(sampleMatrices.getTwoByTwoMatrix());
        Matrix anotherTwoByTwoMatrix = new Matrix(sampleMatrices.getTwoByTwoMatrix());

        int [][]expectedMatrix = new int [2][2];
        expectedMatrix[0][0] = 7;
        expectedMatrix[0][1] = 10;
        expectedMatrix[1][0] = 15;
        expectedMatrix[1][1] = 22;

        Matrix expected = new Matrix(expectedMatrix);
        Matrix actual = matrix.multiplicationOfMatrices(anotherTwoByTwoMatrix);
        assertEquals(expected,actual);
    }

    @Test
    void shouldReturnTransposeOfTwoMatrices() {
        SampleMatrices sampleMatrices = new SampleMatrices();
        Matrix matrix = new Matrix(sampleMatrices.getTwoByTwoMatrix());

        int [][]expectedMatrix = new int [2][2];
        expectedMatrix[0][0] = 1;
        expectedMatrix[0][1] = 3;
        expectedMatrix[1][0] = 2;
        expectedMatrix[1][1] = 4;

        Matrix expected = new Matrix(expectedMatrix);
        Matrix actual = matrix.transposeOfMatrix();
        assertEquals(expected,actual);
    }

}