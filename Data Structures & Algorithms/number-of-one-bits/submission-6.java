class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i<32; i++){
            res = res + n%2;
            n = n/2;
        }
        return res;
    }
}
