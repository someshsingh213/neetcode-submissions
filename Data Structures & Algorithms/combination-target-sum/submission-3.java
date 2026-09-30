class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sol = new ArrayList<>();
        dfs(0, sol, 0, nums, target);
        return res;
    }

    void dfs(int i, List<Integer> sol, int currSum, int[] nums, int target) {
        if(i == nums.length){
            return;
        }
        if(currSum == target){
            res.add(new ArrayList<>(sol));
            return;
        }

        if(currSum > target){
            return;
        }

        // we choose i again
        sol.add(nums[i]);
        dfs(i, sol, currSum + nums[i], nums, target);
        sol.removeLast();

        //do we not choose i i.e. move ahead
        dfs(i+1, sol, currSum, nums, target);
    }


}
