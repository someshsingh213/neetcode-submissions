class Solution {
    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        generateParanthesisRecursive(n, "", 0, 0); 
        return list;
    }

    public void generateParanthesisRecursive(int n, String s, int open, int close){
        if(open == close && open == n){
            list.add(s);
            return;
        }
        if(open<close || open>n){
            return;
        }
        generateParanthesisRecursive(n, s+"(", open+1, close);
        generateParanthesisRecursive(n, s+")", open, close + 1);
    }
}
