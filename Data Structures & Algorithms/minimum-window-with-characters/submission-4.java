class Solution {
    public String minWindow(String s, String t) {
        //start from left = 0 and right = 0 + t.length;
        //maintain a minimum actual string the loop, and minimum length
        //if new minimum is reached, update it. 
        //keep increasing right until substring is present
        //then decrmeent left to see if its still possible to create subscrtirng

        if(t.length() > s.length()){
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        String minString = "";

        int left = 0;
        int right = left + t.length(); //3

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            //A: 1, B: 1, C: 1
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        while(right < (s.length() + 1)) { //3 < 14
            String substr = s.substring(left, right); //ADO
            HashMap<Character, Integer> substrMap = new HashMap<>();
        for(char c: substr.toCharArray()){ //A: 1, D: 1, O:1
            if(substrMap.containsKey(c)){
                substrMap.put(c, substrMap.get(c) + 1);
            } else {
                substrMap.put(c, 1);
            }
        }
        int count = 0;
        for(char ch : map.keySet()){
            if (map.get(ch) <= substrMap.getOrDefault(ch, 0)) {
                count = count + map.get(ch);
            }
        }
        if(count == t.length()) {
            if(substr.length() < minLength){
                minString = substr;
                minLength = substr.length();
            }
            left ++;
        } else{
            right ++;
        } 
            
        }

        return minString;
    }
}
