class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String, List<String>> res = new Hashtable<>();
        for(String s : strs) {
            int[] count = new int[26];
            for( char c : s.toCharArray()) {
                count[c-'a']++;
            }
            res.putIfAbsent(Arrays.toString(count), new ArrayList<>());
            res.get(Arrays.toString(count)).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
