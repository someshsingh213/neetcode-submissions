class Solution {
    int maxProfit;
    HashMap<Integer, Integer> sellMemo; //index, maxProfitFromThisIndex
    HashMap<Integer, Integer> buyMemo; //index, maxProfitFromThisIndex
    int [] prices;
    public int maxProfit(int[] prices) {
        maxProfit = 0;
        sellMemo = new HashMap<>();
        buyMemo = new HashMap<>();
        this.prices = prices;
        return dfs(0, "buy");
        //return buyMemo.get(0);
    }

    int dfs(int index, String type) {
        if(type.equals("buy") && index >= prices.length - 1){
            buyMemo.put(index, 0);
            return 0;
        }
        if(index >= prices.length){
            return 0;
        }

        if(type.equals("buy")){
            //choice A - buy today
            if(buyMemo.get(index) != null){
                return buyMemo.get(index);
            }
            int choiceA = dfs(index + 1, "sell") - prices[index];
            //choice B - don't buy today
            int choiceB = dfs(index + 1, "buy");
            buyMemo.put(index, Math.max(choiceA, choiceB));
            return buyMemo.get(index);

        } else {
            if(sellMemo.get(index)!=null){
                return sellMemo.get(index);
            }
            int choiceA = dfs(index + 2, "buy") + prices[index];
            int choiceB = dfs(index + 1, "sell");
            sellMemo.put(index, Math.max(choiceA, choiceB));
            return sellMemo.get(index);
        } 
    }
}
