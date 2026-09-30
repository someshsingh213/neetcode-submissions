class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        dfs(0, sol, nums);
        return res;
    }

    void dfs(int i, List<Integer> sol, int [] nums) {
        if(i == nums.length){
            res.add(new ArrayList<>(sol));
            return;
        }

        //choose i
        sol.add(nums[i]);
        dfs(i+1, sol, nums);
        sol.removeLast();

        //don't choose i
        dfs(i+1, sol, nums);
    }
}
