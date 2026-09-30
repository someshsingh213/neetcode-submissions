class Solution {
    List<String> res;
    String digits;
    Map<Character, List<Character>> map;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        this.digits = digits;
        map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        dfs(0, "");
        return res.size() == 1 && res.get(0) == "" ? new ArrayList<>(): res;
    }

    void dfs(int i, String curStr) {

        if(i >= digits.length()){
            res.add(curStr);
            return;
        }
        char digit = digits.charAt(i);
        List<Character> chars = map.get(digit);
        for(char ch: chars){
            dfs(i+1, curStr + ch);
        }
    } 
}
