class Solution {
    int sum;
    public int uniquePaths(int m, int n) {
        sum = 0;
        dfs(0, 0, m, n);
        return sum;
    }

    void dfs(int row, int col, int numRows, int numCols){
        if(row >= numRows || row < 0 || col >=numCols || col < 0){
            return;
        }

        if(row == numRows - 1 && col == numCols - 1){
            sum++;
            return;
        }

        //pick the right path
        dfs(row, col+1, numRows, numCols);

        //pick the bottm path
        dfs(row+1, col, numRows, numCols);
    }
}
