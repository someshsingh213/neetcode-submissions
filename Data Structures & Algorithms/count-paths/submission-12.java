class Solution {
    int [][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        dfs(0,0,m,n);
        return memo[0][0];
    }

    int dfs(int row, int col, int m, int n){
        if(row<0 || row>=m || col <0 || col>=n){
            return 0;
        }

        if(memo[row][col] > 0){
            return memo[row][col];
        }

        if(row == m - 1 && col == n - 1){
            memo[row][col] = 1;
            return memo[row][col];
        }

        memo[row][col] = dfs(row + 1, col, m, n) + dfs(row, col + 1, m, n);
        return memo[row][col];
    }

}
