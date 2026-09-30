class Solution {
    int [] coins;
    int amount;
    int [] dp;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;
        dp = new int[amount + 1];
        dp[0] = 0;
        dfs(amount);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    int dfs(int amount) {
        if(amount == 0){
            return 0;
        }

        if(dp[amount] != 0){
            return dp[amount];
        }

        int res = Integer.MAX_VALUE;
        for(int coin: coins) {
            if((amount - coin) >= 0){
                int result = dfs(amount - coin);
                if(result!=Integer.MAX_VALUE){
                    res = Math.min(result + 1, res);
                }
            }
        }

        dp[amount] = res;
        return res;
    }
}
