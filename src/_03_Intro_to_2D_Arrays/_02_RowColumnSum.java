package _03_Intro_to_2D_Arrays;

public class _02_RowColumnSum {

    public int getSumByRow(int[][] matrix, int row) {
    	int x = 0;
    	for(int i = 0; i < matrix[row].length; i++) {
    		x += matrix[row][i];
    	}
        return x;
    }
    
    public int getSumByColumn(int[][] matrix, int col) {
    	int x = 0;
    	for(int i = 0; i < matrix.length; i++) {
    		x += matrix[i][col];
    	}
        return x;
    }
}
