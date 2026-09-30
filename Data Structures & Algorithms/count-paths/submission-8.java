class Solution {
    int [][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int [m][n];
        return dfs(0,0,m,n);
    }

    int dfs(int row, int col, int numRows, int numCols) {
        if(row >= numRows || row < 0 || col >= numCols || col < 0  ){
            return 0;
        }

                if(memo[row][col] != 0){
            return memo[row][col];
        }
        
        if(row == numRows - 1 && col == numCols - 1){
            return 1;
        }



        return memo[row][col] = dfs(row, col+1, numRows, numCols) + dfs(row+1, col, numRows, numCols);
    }
}
