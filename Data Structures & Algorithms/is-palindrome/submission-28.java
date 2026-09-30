class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        s = s.toLowerCase();
        while(i<=j){
            if(!isAlphaNumeric(s, i)){i++; continue;}
            if(!isAlphaNumeric(s, j)){j--; continue;}

            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    boolean isAlphaNumeric(String s, int i) {
        if(((s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <=9) || (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <=25))){
                return true;
            }
            return false;
    }
}
