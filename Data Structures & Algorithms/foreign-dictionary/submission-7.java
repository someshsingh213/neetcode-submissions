class Solution {
    Set<Character> uniqueLetters;
    Set<Character> visited;
    Set<Character> cycle;
    List<Character> res;
    HashMap<Character, List<Character>> edges;
    public String foreignDictionary(String[] words) {
        uniqueLetters = new HashSet<>();
        visited = new HashSet<>();
        cycle = new HashSet<>();
        res = new ArrayList<>();
        edges = new HashMap<>();
        for(String word: words) {
            for(char c: word.toCharArray()) {
                uniqueLetters.add(c);
            }
        }

        for(int z = 0; z<words.length - 1; z++){
            String w1 = words[z];
            String w2 = words[z+1];

            int m = w1.length();
            int n = w2.length();

            int i = 0;
            int j = 0;

            while(i < m && j < n) {
                if(w1.charAt(i) == w2.charAt(j)){
                    i++;
                    j++;
                } else {
                    break;
                }
            }

            if(i < m && j < n) {
                if(!edges.containsKey(w1.charAt(i))){
                    edges.put(w1.charAt(i), new ArrayList<>());
                }
                edges.get(w1.charAt(i)).add(w2.charAt(j));
            } else if (i < m) {
                return "";
            }
        }

        for(char c: uniqueLetters) {
            if(dfs(c) == false) {
                return "";
            }
        }

        String result = "";
        for(int i = res.size()-1; i>=0; i--){
            result = result + res.get(i);
        }

        return result;
    }

    boolean dfs(char c) {
        if(visited.contains(c)){
            return true;
        }

        if(cycle.contains(c)){
            return false;
        }

        cycle.add(c);

        List<Character> chars = edges.get(c);
        if (chars!=null) {
            for(char ch: chars){
            if(dfs(ch) == false){
                return false;
            }
        }
        }
        

        cycle.remove(c);
        res.add(c);
        visited.add(c);
        return true;
    }
}
