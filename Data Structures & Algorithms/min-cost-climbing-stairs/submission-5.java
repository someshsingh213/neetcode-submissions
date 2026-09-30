public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        //base
        if( i >= cost.length){
            return 0;
        }
        //recursive function
        int x;
        if(map.get(i+1) != null){
            x = map.get(i+1);
        } else {
            x = dfs(cost, i+1);
        }
        int y;
        if(map.get(i+2)!=null){
            y = map.get(i+2);
        } else {
            y = dfs(cost, i+2);
        }
        //logic
        int res = cost[i] + Math.min(x,y);
        //return
        return res;
    }
}