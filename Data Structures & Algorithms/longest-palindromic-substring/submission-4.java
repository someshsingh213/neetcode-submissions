class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for(int i = 0; i<s.length(); i++){
            //odd
            int left = i;
            int right = i;
            while(left >= 0 && right <s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    if(right - left + 1 > maxLength){
                        maxLength = right - left + 1;
                        maxLeft = left;
                        maxRight = right;
                    }
                    left = left - 1;
                    right = right + 1;
                } else {
                    break;
                }
            }


            //even
        }

        for(int i = 0; i<s.length(); i++){
            //odd
            int left = i;
            int right = i+1;
            while(left >= 0 && right <s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    if(right - left + 1 > maxLength){
                        maxLength = right - left + 1;
                        maxLeft = left;
                        maxRight = right;
                    }
                    left = left - 1;
                    right = right + 1;
                } else {
                    break;
                }
            }

            
            //even
        }

        return s.substring(maxLeft, maxRight+1);
    }
}
