public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int x = 0;
        int y = 0;
        int z = 0;
        for(int i = 2; i <cost.length + 1; i++){
            z = Math.min(y + cost[i-1], x+ cost[i-2]);
            x = y;
            y = z;
        }
        return z;
        }
}