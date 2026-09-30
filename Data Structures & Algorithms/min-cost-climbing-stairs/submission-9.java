public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] costToReachStairs = new int[cost.length + 1];
        costToReachStairs[0] = 0;
        costToReachStairs[1] = 0;
        for(int i = 2; i <cost.length + 1; i++){
            costToReachStairs[i] = Math.min(costToReachStairs[i-1] + cost[i-1], costToReachStairs[i-2]+ cost[i-2]);
        }
        return costToReachStairs[cost.length];
        }
}