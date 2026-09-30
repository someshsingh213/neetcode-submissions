class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            if(map.get(ch)!=null){
                map.put(ch, map.get(ch) + 1);
            } else{
                map.put(ch, 1);
            }
        }

        int left = 0;
        int right = left + s1.length() - 1;
        HashMap<Character, Integer> mapOfCurrWindow = new HashMap<>();
        for(int i = left; i<=right; i++) {
            char ch = s2.charAt(i);
            if(mapOfCurrWindow.get(ch)!=null){
                mapOfCurrWindow.put(ch, mapOfCurrWindow.get(ch) + 1);
            } else{
                mapOfCurrWindow.put(ch, 1);
            }
        }

        while(right < s2.length()){
            int len = 0;
            for(char ch: map.keySet()){
                if(map.get(ch) != mapOfCurrWindow.get(ch)){
                    mapOfCurrWindow.put(s2.charAt(left), mapOfCurrWindow.get(s2.charAt(left)) - 1);
                    left++;
                    break;

                } else {
                    len ++;
                }
            }
            if(len == map.keySet().size()){
                return true;
            }
            right++;
            if(right >= s2.length()){
                break;
            }
            if(mapOfCurrWindow.get(s2.charAt(right))!=null){
                mapOfCurrWindow.put(s2.charAt(right), mapOfCurrWindow.get(s2.charAt(right)) + 1);
            } else{
                mapOfCurrWindow.put(s2.charAt(right), 1);
            }
        }
        return false;
    }
}
