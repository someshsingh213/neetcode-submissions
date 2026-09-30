class Solution {
    List<List<Integer>> res;
    int [] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        dfs(0, new ArrayList<>(), 0);
        return res;
    }

    void dfs(int i, List<Integer> list, int sum) {
        
        if(sum == target) {
            res.add(new ArrayList<>(list));
            return ;
        }

        if(i >= candidates.length){
            return;
        }
        //choose i
        list.add(candidates[i]);
        dfs(i+1, list, sum + candidates[i]);
        

        //don't choose i
        list.removeLast();
        while(i+1 < candidates.length && candidates[i+1] == candidates[i]){
            i = i+1;
        }
        dfs(i+1, list, sum);
    }
}
