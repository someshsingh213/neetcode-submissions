class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int maxLeft = -1;
        int maxRight = -1;

        for(int i = 0; i <s.length(); i++){
            int l = i;
            int r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(max < r - l + 1){
                    max = r - l + 1;
                    maxLeft = l;
                    maxRight = r;
                }
                l--;
                r++;
            }
        }

        for(int i = 0; i <s.length() -1; i++){
            int l = i;
            int r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(max < r - l + 1){
                    max = r - l + 1;
                    maxLeft = l;
                    maxRight = r;
                }
                l--;
                r++;
            }
        }

        return s.substring(maxLeft, maxRight+1);
    }
}
