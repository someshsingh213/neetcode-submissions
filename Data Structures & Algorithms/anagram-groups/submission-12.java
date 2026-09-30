class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable <Hashtable, ArrayList<String>> tableOfStrings = new Hashtable<>();
        for(int i =0; i<strs.length; i++){
            Hashtable<Character,Integer> tableOfLetters = new Hashtable<>();
            for(int j = 0; j<strs[i].length(); j++) {
                tableOfLetters.put(strs[i].charAt(j), tableOfLetters.getOrDefault(strs[i].charAt(j), 0) + 1 );
            }
            if(tableOfStrings.get(tableOfLetters) == null){
                tableOfStrings.put(tableOfLetters, new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                tableOfStrings.get(tableOfLetters).add(strs[i]);
            }
        }
        List<List<String>> listOfAnagrams = new ArrayList<>();
        for(Hashtable key: tableOfStrings.keySet()){
            listOfAnagrams.add(tableOfStrings.get(key));
        }
        return listOfAnagrams;
    }
}
