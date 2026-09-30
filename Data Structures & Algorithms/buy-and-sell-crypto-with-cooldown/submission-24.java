class Solution {
    int [] prices;
    HashMap<Integer, Integer> buyMemo;
    HashMap<Integer, Integer> sellMemo;
    public int maxProfit(int[] prices) {
        this.buyMemo = new HashMap<>();
        this.sellMemo = new HashMap<>();
        this.prices = prices;
        return dfs(0, "buy");
    }

    public int dfs(int index, String type){
        if(index >= prices.length || (type.equals("buy") && index == prices.length - 1)){
            return 0;
        }
        if(type.equals("buy")){
            if(buyMemo.get(index)!=null){
                return buyMemo.get(index);
            } else {
                int res = (Math.max(dfs(index+1, "buy"), dfs(index+1, "sell") - prices[index]));
                buyMemo.put(index, res);
                return res;
            }
            
        } else {
            if(sellMemo.get(index)!=null){
                return sellMemo.get(index);
            } else {
                int res = (Math.max(dfs(index+1, "sell"), dfs(index+2, "buy") + prices[index]));
                sellMemo.put(index, res);
                return res;
            }
            
        }
    }
}
