class Solution {
    public boolean isPalindrome(String s) {
        String cpy = "";
        s = s.toLowerCase();
        for(int i = 0; i<s.length(); i++){
            if(((s.charAt(i) - '0' >= 0 && (s.charAt(i) - '0' <= 9))  || ((s.charAt(i) - 'a') <= 25) && (s.charAt(i) - 'a') >= 0)) {
                cpy = cpy + s.charAt(i);
            }
        }

        if(cpy.equals(new StringBuilder(cpy).reverse().toString())){
            return true;
        }
        return false;
    }
}
