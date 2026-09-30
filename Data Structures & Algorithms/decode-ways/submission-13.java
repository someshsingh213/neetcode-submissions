class Solution {
    String s;
    public int numDecodings(String s) {
        this.s = s;
        return dfs(0);
    }

    int dfs(int i) {
        if(i >= s.length()) {
            return 1;
        } 

        //choose i
        char char1 = s.charAt(i);
        if(char1 == '0'){
            return 0;
        }
        int choice1 = dfs(i+1);

        int choice2 = 0;
        if(!(i+1 >=s.length())){
            int num = Integer.parseInt("" + s.charAt(i) + s.charAt(i+1));
            if((num < 10 || num > 26)){
                return choice1;
            }
        } else {
            return choice1;
        }
        //choose i, i+1
        choice2 = dfs(i+2);

        return choice1 + choice2;
    }
}
