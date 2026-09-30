class PrefixTreeNode {
    private char val;
    private HashMap<Character, PrefixTreeNode> children;
    private boolean endOfWord;

    public PrefixTreeNode(char val, HashMap<Character, PrefixTreeNode> children, boolean endOfWord) {
        this.val = val;
        this.children = children;
        this.endOfWord = endOfWord;
    }
}

class PrefixTree {

    private PrefixTreeNode root;

    public PrefixTree() {
        HashMap<Character, PrefixTreeNode> children = new HashMap<>();
        this.root = new PrefixTreeNode('\0', children, false);
    }

    public void insert(String word) {
        PrefixTreeNode traversingRoot = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if (!traversingRoot.children.containsKey(ch)){
                HashMap<Character, PrefixTreeNode> child = new HashMap<>();
                traversingRoot.children.put(ch, new PrefixTreeNode(ch, child, false));
            }
            traversingRoot = traversingRoot.children.get(ch);
            if(i == word.length() - 1){
                traversingRoot.endOfWord = true;
            }
        }
    }

    public boolean search(String word) {
        PrefixTreeNode traversingRoot = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(traversingRoot.children.containsKey(ch)){
                traversingRoot = traversingRoot.children.get(ch);
                if(i == word.length() - 1){
                if(traversingRoot.endOfWord == true){
                    return true;
                }
            }
            }
            
        }
        return false;   
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode traversingRoot = root;
        for(int i = 0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(traversingRoot.children.containsKey(ch)){
                traversingRoot = traversingRoot.children.get(ch);
                if(i == prefix.length() - 1){
                    return true;
            }
            }
            
        }
         return false;  
    }
}
