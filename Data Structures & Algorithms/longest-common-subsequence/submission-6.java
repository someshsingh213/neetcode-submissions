class Solution {
    HashMap<String, Integer> memo;
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        Brute force solution:
        Find all subsequences of text1: 2^n, where n = text1.length
        Find all subsequences of text2: 2^m, where m = text2.length
        Put both of these in an array and see where they are equal
        - O(2^m * 2*n) = O(2^mn) brute force complexity
        */

        /*
        In optimized solution, I will have to find O(n*m) complexity
        Decision at ith step:
            if(charAt(i) == charAt(;)){
                memo[i][j] = 1 + dfs(i+1, j+1)
            } else {

            }
        */

        memo = new HashMap<>();
        return dfs(text1, text2, 0, 0);

    }

    int dfs(String text1, String text2, int i, int j) {
        if(i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            if(memo.get(i + "," +j ) == null){
                memo.put((i + "," +j), 1 + dfs(text1, text2, i+1, j+1));
            }
            return memo.get(i + "," +j);
        } else {
            if(memo.get(i + "," +j ) == null){
                memo.put((i + "," +j), Math.max(dfs(text1, text2, i+1, j), dfs(text1, text2, i, j+1)));
            } else {
               
            }
             return memo.get(i + "," +j);
        }
    }
}
