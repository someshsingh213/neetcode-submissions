class Solution {
    int [] dp;
    String s;
    public int numDecodings(String s) {
        dp = new int [s.length()];
        this.s = s;
        dfs(0);
        return dp[0];
    }

    int dfs(int i) {
        

        if(i == s.length()) {
            return 1;
        }

        if(dp[i] != 0){
            return dp[i];
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        int res = 0;
        if(s.charAt(i) - '0' >= 1 && s.charAt(i) - '0' <= 9){
            res = res + dfs(i+1);
        }

        if(i+1 <= s.length() - 1) {
            int num = Integer.parseInt("" + s.charAt(i) + s.charAt(i+1));
            if(num >= 10 && num <= 26) {
                res = res + dfs(i+2);
            }
        }

        dp[i] = res;
        return res;
    }
}
