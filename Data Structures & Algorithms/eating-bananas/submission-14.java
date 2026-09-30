class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxVal = piles[0];
        for(int i = 0; i<piles.length; i++){
            maxVal = Math.max(maxVal, piles[i]);
        }
        int low = 1;
        int high = maxVal;
        int mid = low + (high - low)/2;
        int ret = maxVal;
        while(high>=low){
            mid = low + (high - low)/2;
            int sum = 0;
            for(int i = 0; i<piles.length; i++){
                sum = sum + (int) Math.ceil((piles[i]*1.0)/mid );
            }

            if(sum > h){
                low = mid + 1;
            } else {
                high = mid - 1;
                ret = Math.min(ret, mid);
            }
            
        }

        return ret;
    }
}
