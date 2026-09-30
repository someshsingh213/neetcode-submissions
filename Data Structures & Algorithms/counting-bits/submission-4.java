class Solution {
    public int[] countBits(int n) {
        int [] dp = new int[n+1];
        int offset = 1; //2 ^0
        for(int i = 1; i<=n; i++){
            if(offset * 2 == i){
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }

    public int countOnes(int n){
        int res = 0;
        while(n!=0){
            n = n&(n-1);
            res++;
        }
        return res;
    }
}
