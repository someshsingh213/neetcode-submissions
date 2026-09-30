public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        //base
        if( i >= cost.length){
            return 0;
        }
        //recursive function
        int x = dfs(cost, i+1);
        int y = dfs(cost, i+2);
        //logic
        int res = cost[i] + Math.min(x,y);
        //return
        return res;
    }
}