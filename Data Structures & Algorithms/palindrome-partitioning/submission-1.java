class Solution {
    List<List<String>> list;
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        list = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return list;
    }

    void dfs(int index, List<String> subList) {
        if(index >= s.length()) {
            list.add(new ArrayList<>(subList));
            return;
        }

        for(int j = index; j<s.length(); j++){
            if(isPalindrome(index, j)){
                subList.add(s.substring(index, j+1));
                dfs(j+1, subList);
                subList.removeLast();
            }
        }
    }

    boolean isPalindrome(int l, int r) {
        while(l < r) {
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}
