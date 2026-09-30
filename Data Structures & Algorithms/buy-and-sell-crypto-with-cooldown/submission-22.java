class Solution {
    int [] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        return dfs(0, "buy");
    }

    public int dfs(int index, String type){
        if(index >= prices.length){
            return 0;
        }
        if(type.equals("buy")){
            return (Math.max(dfs(index+1, "buy"), dfs(index+1, "sell") - prices[index]));
        } else {
            return (Math.max(dfs(index+1, "sell"), dfs(index+2, "buy") + prices[index]));
        }
    }
}
