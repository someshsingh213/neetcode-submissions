class Node {
    char ch;
    HashMap<Character,Node> children;
    boolean endOfWord;
    Node(char ch) {
        this.ch = ch;
        children = new HashMap<>();
        endOfWord = false;
    }
}
class WordDictionary {
    Node root;
    boolean res;
    public WordDictionary() {
        root = new Node('\u0000');
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children.containsKey(ch)){
            } else {
                curr.children.put(ch, new Node(ch));
            }
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        res = false;
        dfs(root, word, 0);
        return res;
    }

    void dfs(Node node, String word, int i) {
        if( i == word.length()){
            res = node.endOfWord;
            return;
        }
        Node curr = node;
            char ch = word.charAt(i);
            if(ch == '.'){
                HashMap<Character, Node> children = curr.children;
                for(Node childNode : children.values()){
                    dfs(childNode, word, i + 1);
                }
            } else if(curr.children.containsKey(ch)){
                dfs(curr.children.get(ch), word, i+1);
            } else {
                //res = false;
                return;
            }
    }
}
