class TrieNode {
    char val;
    HashMap<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode(char ch) {
        val = ch;
        children = new HashMap<>();
        endOfWord = false;
    }
}
class Solution {
    Set<String> list;
    TrieNode root;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        //create a trie using words
        root = new TrieNode('0');
        this.board = board;
        for(String word: words){
            TrieNode curr = root;
            for(int i = 0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(curr.children.containsKey(ch)){
                    curr = curr.children.get(ch);
                } else {
                    curr.children.put(ch, new TrieNode(ch));
                    curr = curr.children.get(ch);
                }
            }
            curr.endOfWord = true;
        }

        list = new HashSet<>();
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                dfs(i, j, "", new HashSet<>(), root);
            }
        }

        return new ArrayList<>(list);

    }

    void dfs(int i, int j, String word, HashSet<String> visited, TrieNode node){
         if(node.endOfWord == true){
            list.add(word);
        }
        
        if(i >= board.length || i<0 || j<0 || j >= board[0].length || visited.contains(i+","+j)) {
            return;
        }

       

        if(node.children.containsKey(board[i][j])){
            word = word + board[i][j];
            node = node.children.get(board[i][j]);
            visited.add(i + "," + j);
            //left
            dfs(i,j-1,word, visited, node);
            //top
            dfs(i-1,j,word, visited, node);
            //right
            dfs(i,j+1,word, visited, node);
            //bottom
            dfs(i+1,j,word, visited, node);
            visited.remove(i + "," + j);
        }
    }
}
