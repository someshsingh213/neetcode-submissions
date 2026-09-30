class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        int best = 0;
        while(right<s.length()){
             map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0) + 1);
            max = Math.max(max, map.get(s.charAt(right)));
            if((right - left + 1) - max > k){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0) - 1);
                left++;
            }
           
            best = Math.max(best, right - left + 1);
            right++;
        }
        return best;
    }
}
