class Solution {
    Map<Integer, Integer> dp;
    String s;
    public int numDecodings(String s) {
        dp = new HashMap<>();
        this.s = s;
        dfs(0);
        return dp.get(0);
    }

    int dfs(int i) {

        if(dp.containsKey(i)){
            return dp.get(i);
        }
        
        if(i == s.length()) {
            dp.put(i, 1);
            return 1;
        }

        

        if(s.charAt(i) == '0'){
            dp.put(i, 0);
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

        dp.put(i, res);
        return res;
    }
}
