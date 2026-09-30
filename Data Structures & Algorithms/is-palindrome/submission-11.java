class Solution {
    public boolean isPalindrome(String s) {
        Set<Character> str = new HashSet<>();
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1; 

        while(i<=j){
            if(!(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                i++;
                continue;
            }
            if(!(Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j)))){
                j--;
                continue;
            }
            str.add(s.charAt(i));
            str.remove(s.charAt(j));
            if(!str.isEmpty()){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
