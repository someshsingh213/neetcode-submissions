class Solution {
    public boolean isPalindrome(String s) {
        String strWithoutUnneededChars = "";
        for(char c: s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                strWithoutUnneededChars = strWithoutUnneededChars + c;
            }
        }

        strWithoutUnneededChars = strWithoutUnneededChars.toLowerCase();

        String reversedStr = "";
        for(int i = strWithoutUnneededChars.length() - 1; i>=0; i--){
            reversedStr = reversedStr + strWithoutUnneededChars.charAt(i);
        }

        return reversedStr.equals(strWithoutUnneededChars);
    }
}
