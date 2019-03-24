package day7.matrix;

class SampleMatrices {

    private int [][]twoByTwoMatrix;

    SampleMatrices() {
        this.twoByTwoMatrix = new int[2][2];
    }

    int[][] getTwoByTwoMatrix() {
        twoByTwoMatrix[0][0] = 1;
        twoByTwoMatrix[0][1] = 2;
        twoByTwoMatrix[1][0] = 3;
        twoByTwoMatrix[1][1] = 4;

        return twoByTwoMatrix;
    }
}
