/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0074;

/**
 *
 * @author Admin
 */
public class calculatorProgram {

    public calculatorProgram() {
    }

    //addition matrixes
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] additionMatrix = null;
        //check if the sizes of 2 matrixes are equal
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            int row = matrix1.length;
            int column = matrix1[0].length;
            additionMatrix = new int[row][column];
            //traverse from first element to last element of row in additionMatrix
            for (int i = 0; i < row; i++) {
                //traverse from first elemnt to last element of column in additionMatrix
                for (int j = 0; j < column; j++) {
                    additionMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

        }
        return additionMatrix;
    }

    //sutraction matrixes
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] subtractionMatrix = null;
        //check if the sizes of 2 matrixes are equal
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            int row = matrix1.length;
            int column = matrix1[0].length;
            subtractionMatrix = new int[row][column];
            //traverse from first element to last element of row in subtractionMatrix
            for (int i = 0; i < row; i++) {
                //traverse from first elemnt to last element of column in subtractionMatrix
                for (int j = 0; j < column; j++) {
                    subtractionMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }

        }
        return subtractionMatrix;
    }

    //multiplication matrixes
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] multiplicationMatrix = null;
        //check if column size of matrix1 is equal to row size of matrix2 
        if (matrix1[0].length == matrix2.length) {
            int row = matrix1.length;
            int column = matrix2[0].length;
            multiplicationMatrix = new int[row][column];
            //traverse from first element to last element of row in multiplicationMatrix
            for (int i = 0; i < row; i++) {
                //traverse from first element to last element of column in multiplicationMatrix
                for (int j = 0; j < column; j++) {
                    //traverse from first element to last element of row in matrix 2
                    for (int k = 0; k < matrix2.length; k++) {
                        multiplicationMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        }
        return multiplicationMatrix;
    }
}
