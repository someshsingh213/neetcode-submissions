class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int lenOfCharacterSeenMost = 0;
        int lenOfSubstring = 0;
        String c = s;
        while(right >= left && right<s.length()){
            if(map.get(c.charAt(right)) == null) {
                map.put(c.charAt(right), 1);
            } else {
                map.put(c.charAt(right), map.get(c.charAt(right)) + 1);
            }

            if(map.get(c.charAt(right)) > lenOfCharacterSeenMost){
                lenOfCharacterSeenMost = map.get(c.charAt(right));
            }

            if(right - left + 1 - lenOfCharacterSeenMost <= k){
                lenOfSubstring = Math.max(lenOfSubstring, right - left + 1);
            } else {
                map.put(c.charAt(left), map.get(c.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return lenOfSubstring;
    }
}
