class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int []> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i))[1] = i;
            } else {
                map.put(s.charAt(i), new int [] {i, i});
            }
        }

        int begin = 0;
        int end = 0;
        char ch = s.charAt(0);
        begin = map.get(ch)[0];
        end = map.get(ch)[1];
        List<Integer> res = new ArrayList<>();
        while(begin >= 0 && end <= s.length() - 1){
            
            for(int i = begin; i<=end; i++){
                end = Math.max(end,map.get(s.charAt(i))[1]);
            }
            res.add(end - begin + 1);
            begin = end + 1;
            if(begin >= s.length()){
                break;
            }
            end = map.get(s.charAt(begin))[1];
        }

        return res;
    }
}
