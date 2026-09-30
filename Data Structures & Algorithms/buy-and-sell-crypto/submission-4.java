class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int profit = 0;
        while(left < right && right<prices.length){
            profit = Math.max(profit, prices[right] - prices[left]);
            if(prices[right] - prices[left] <= 0) {
                left ++;
                right = left+1;
            } else {
                right++;
            }
        }

        return profit;
    }
}
