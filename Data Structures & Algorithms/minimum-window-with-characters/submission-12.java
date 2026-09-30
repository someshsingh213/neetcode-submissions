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
            //A: 1, B: 1, C: 1
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
            char c = s.charAt(i); //C
            if(map.containsKey(c) && !indexSeen.contains(i)){
                map.put(c, map.get(c) - 1); //A:0, B: -1, C:-1
            }
            indexSeen.add(i); //0,1,2,3,4,5,6,7,8,9,10,11,12
            if(isMapEmpty(map)){
                if(right - left < minLength){
                    minLength = right - left ; //6
                    minLeft = left;//0
                    minRight = right;//6
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1); //A:1,B:0,C:0
                }
                left++;//1
                i--;//4
            } else {
                right++; //14
            }
            
            i++; //13
        }
        return s.substring(minLeft, minRight);
    }

    //O(52) so constant operation
    boolean isMapEmpty(HashMap<Character, Integer> map) {
        for(char c: map.keySet()){
            if(map.get(c) > 0){
                return false;
            }
        }
        return true;
    }
}