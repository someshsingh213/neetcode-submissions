class Solution {
    public double myPow(double x, int n) {
        double ret = dfs(x, Math.abs(n));
        return n > 0 ? ret : 1/ret;
    }

    public double dfs(double x, int n) {
        if(n == 0){
            return 1;
        }

        return x * dfs(x, n-1);
    }

    
}
