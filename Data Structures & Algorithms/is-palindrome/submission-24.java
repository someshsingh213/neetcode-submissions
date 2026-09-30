class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        s = s.toLowerCase();
        while(i<=j){
            if(!((s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <=9) || (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <=25))){
                i++;
                continue;
            }

            if(!((s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <=9) || (s.charAt(j) - 'a' >= 0 && s.charAt(j) - 'a' <=25))){
                j--;
                continue;
            }

            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
