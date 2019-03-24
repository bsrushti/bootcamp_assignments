package day7.matrix;

class SampleMatrices {

    private int [][]twoByTwoMatrix;
    private int [][]twoByThreeMatrix;

    SampleMatrices() {
        this.twoByTwoMatrix = new int[2][2];
        this.twoByThreeMatrix = new int[2][3];
    }

    int[][] getTwoByTwoMatrix() {
        twoByTwoMatrix[0][0] = 1;
        twoByTwoMatrix[0][1] = 2;
        twoByTwoMatrix[1][0] = 3;
        twoByTwoMatrix[1][1] = 4;

        return twoByTwoMatrix;
    }

    int[][] getTwoByThreeMatrix() {
        twoByThreeMatrix[0][0] = 1;
        twoByThreeMatrix[0][1] = 2;
        twoByThreeMatrix[0][2] = 3;
        twoByThreeMatrix[1][0] = 4;
        twoByThreeMatrix[1][1] = 5;
        twoByThreeMatrix[1][2] = 6;

        return twoByThreeMatrix;
    }


}
