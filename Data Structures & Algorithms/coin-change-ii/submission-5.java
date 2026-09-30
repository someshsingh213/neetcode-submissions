class Solution {
    Map<String, Integer> dp; //I have coins starting at index 0, and I have sum, how many times for each [index, sum] pair can I have combinations that sum to amount
    int []  coins;
    int targetSum;
    public int change(int amount, int[] coins) {
        dp = new HashMap<>();
        this.coins = coins;
        targetSum = amount;
        dfs(0, 0);
        return dp.get(0+","+0);
    }

    int dfs(int i, int sum) {
        if(dp.containsKey(i+","+sum)) {
            return dp.get(i+","+sum);
        }
        if(i >= coins.length || sum > targetSum){
            return 0;
        }
        if(sum == targetSum){
            dp.put(i+","+sum, 1);
            return 1;
        }

        int choice1 = dfs(i, sum+coins[i]);
        int choice2 = dfs(i+1,sum);

        dp.put(i+","+sum, choice1+choice2);
        return choice1+choice2;
    }
}
