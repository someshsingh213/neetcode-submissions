class Solution {
    public int[] countBits(int n) {
        int [] num = new int[n+1];
        for(int i = 0; i<=n; i++){
            num[i] = countOnes(i);
        }
        return num;
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
