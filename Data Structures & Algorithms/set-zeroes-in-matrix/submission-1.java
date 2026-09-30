class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean [] rowZero = new boolean[rows];
        boolean [] colZero = new boolean[cols];

        int [][] grid = matrix;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 0){
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for(int i = 0; i<rows; i++){
            if(rowZero[i]){
                for(int j = 0; j<cols; j++){
                    grid[i][j] = 0;
                }
            }
        }

        for(int i = 0; i<cols; i++){
            if(colZero[i]){
                for(int j = 0; j<rows; j++){
                    grid[j][i] = 0;
                }
            }
        }
    }
}
