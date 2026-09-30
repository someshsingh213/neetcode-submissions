class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int maxProfit = 0;
        while( j<prices.length){
            if(prices[j] - prices[i] > 0){
            maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            j++;
        } else {
            i = j;
            j++;
        }
        }
        return maxProfit;
    }
}
