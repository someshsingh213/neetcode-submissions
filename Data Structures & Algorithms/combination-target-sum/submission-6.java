class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        // Arrays.sort(candidates);
        dfs(target, 0, candidates, 0, new ArrayList<>());
        return list;
    }

    void dfs(int target, int index, int [] candidates, int sum, List<Integer> currList){
        if(sum == target){
            list.add(new ArrayList<>(currList));
            return;
        }

        if(index >= candidates.length){
            return;
        }

        if(sum > target){
            return;
        }


        //choose index
        currList.add(candidates[index]);
        dfs(target, index, candidates, sum + candidates[index], currList);
        
        //not choose index
        currList.removeLast();
        dfs(target, index + 1, candidates, sum, currList);
    }
}
