class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }

        int l = 0;
        int r = map.get(s.charAt(l));
        List<Integer> list = new ArrayList<>();
        int i = l;
        while(i < s.length()){
            
            if(map.get(s.charAt(i)) > r) {
                r = map.get(s.charAt(i));
            }
            
            if(i == r) {
                list.add(r - l + 1);
                if(i+1 >= s.length()){
                    break;
                }
                l = i+1;
                r = map.get(s.charAt(l));
            }
            i++;
        }

        return list;
    }
}
