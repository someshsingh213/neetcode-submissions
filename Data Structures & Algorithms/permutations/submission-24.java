class Solution {
    List<List<Integer>> list;
    int [] nums;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        this.nums = nums;
        dfs(new ArrayList<>(), new HashSet<>());
        return list;
    }

    void dfs(List<Integer> subList, Set<Integer> set){
        if(subList.size() == nums.length){
            list.add(new ArrayList<>(subList));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            subList.add(nums[i]);
            set.add(nums[i]);
            dfs(subList, set);
            subList.removeLast();
            set.remove(nums[i]);
        }
    }
}
