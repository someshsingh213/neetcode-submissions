class Solution {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> charsOfS = new ArrayList<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length() ; i++){
            charsOfS.add(s.charAt(i));
        }
        for(int i = 0; i < t.length() ; i++){
            charsOfS.remove((Character)t.charAt(i));
        }
        if(charsOfS.size() == 0){
            return true;
        }
        return false;

    }
}
