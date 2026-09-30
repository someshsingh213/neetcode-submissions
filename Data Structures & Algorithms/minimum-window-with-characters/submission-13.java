class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()){
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        String minString = "";

        int left = 0;
        int right = 1; 
        int minLeft = 0;
        int minRight = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        
        //O(t)
        for(char c: t.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        //O(s)
        int i =0;
        HashSet<Integer> indexSeen = new HashSet<Integer>();
        while (i < s.length()) {
            char c = s.charAt(i); 
            if(map.containsKey(c) && !indexSeen.contains(i)){
                map.put(c, map.get(c) - 1); 
            }
            indexSeen.add(i); 
            if(doesContainSubstring(map)){
                if(right - left < minLength){
                    minLength = right - left ; 
                    minLeft = left;
                    minRight = right;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                }
                left++;
                i--;
            } else {
                right++; 
            }
            
            i++;
        }
        return s.substring(minLeft, minRight);
    }

    //O(52) so constant operation
    boolean doesContainSubstring(HashMap<Character, Integer> map) {
        for(char c: map.keySet()){
            if(map.get(c) > 0){
                return false;
            }
        }
        return true;
    }
}