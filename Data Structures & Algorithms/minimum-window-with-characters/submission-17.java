class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: t.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0;
        int right = 0;
        int minStringLeft = 0;
        int minStringRight = 0;
        int minLength = Integer.MAX_VALUE;

        int need = map.keySet().size(); //3
        int have = 0;

        HashMap<Character, Integer> currStrMap = new HashMap<>();

        while(right < s.length()) {
            char ch = s.charAt(right);
            if(currStrMap.containsKey(ch)) {
                currStrMap.put(ch, currStrMap.get(ch) + 1);
            } else {
                currStrMap.put(ch, 1);
            }

            if(map.containsKey(ch) && map.get(ch) == currStrMap.get(ch)) {
                have = have + 1;
            }

            while(have == need) {
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    minStringLeft = left;
                    minStringRight = right;
                }

                char leftChar = s.charAt(left);
                currStrMap.put(leftChar, currStrMap.get(leftChar) - 1);

                if (map.containsKey(leftChar) && currStrMap.get(leftChar) < map.get(leftChar)) {
                    have--;
                }
                left++;
            }
            right++;
        }
        if (minLength == Integer.MAX_VALUE) return "";

        return s.substring(minStringLeft, minStringRight + 1);
    }
}