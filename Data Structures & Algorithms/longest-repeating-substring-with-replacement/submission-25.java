class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; 
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxChar = 0;
        int maxLen = 0;
        while(right>=left && right<s.length()){
            if(map.get(s.charAt(right)) == null){
                map.put(s.charAt(right), 1);
            } else {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            }

            maxChar = Math.max(maxChar, map.get(s.charAt(right)));

            if(right - left + 1 - maxChar <= k){
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }

        return maxLen;
    }
}
