class TrieNode {
    char val;
    Map<Character, TrieNode> children;
    boolean isWord;
    TrieNode(char v) {
        val = v;
        children = new HashMap<>();
        isWord = false;
    }
}

class Solution {
    char[][] board;
    String[] words;
    Set<String> set;
    int R;
    int C;
    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        this.set = new HashSet<>();
        R = board.length;
        C = board[0].length;
        root = new TrieNode('0');
        TrieNode curr = root;
         //O(W) where W is sum of all letters of words array
        for(int i = 0; i<words.length; i++){
            String word = words[i];
            for(int j = 0; j<word.length(); j++){
                char ch = word.charAt(j);
                if(!curr.children.containsKey(ch)){
                    curr.children.put(ch, new TrieNode(ch));
                }
                curr = curr.children.get(ch);
            }
            curr.isWord = true;
            curr = root;
        }

        //O(mn)
        boolean [][] visit = new boolean [R][C];
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++){
                dfs(i, j, "",visit , root); //4^length of longestWord
            }
        }

        return new ArrayList<>(set);
    }

    void dfs(int r, int c, String s, boolean [][] visit, TrieNode node) {
        if(r < 0 || c < 0 || r >= R || c >= C || visit[r][c]
        || !node.children.containsKey(board[r][c])) {
            return;
        }

        TrieNode newNode = node.children.get(board[r][c]);
        s = s + board[r][c];
        if(newNode.isWord){
            set.add(s);
        }
        visit[r][c] = true;
        dfs(r-1, c, s, visit, newNode);
        dfs(r, c+1, s, visit, newNode);
        dfs(r+1, c, s, visit, newNode);
        dfs(r, c-1, s, visit, newNode);
        visit[r][c] = false;
    }

}
