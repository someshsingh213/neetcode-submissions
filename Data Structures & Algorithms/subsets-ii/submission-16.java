class Solution {
    List<List<Integer>> res;
    int len;
    int [] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        len = nums.length;
        this.nums = nums;
        dfs(0, new ArrayList<>(), new HashSet<>());
        return res;
    }

    void dfs(int i, List<Integer> list, Set<Integer> set) {

        if(i >= len) {
            res.add(new ArrayList<>(list));
            return;
        }
        //choose i
        boolean shouldRemove = false;
        if(!set.contains(nums[i])){
            shouldRemove = true;
        }
        set.add(nums[i]);
        list.add(nums[i]);
        dfs(i+1,list,set);
        if(shouldRemove){
            set.remove(nums[i]);
        }
        list.removeLast();
        //don't choose i
        if(!set.contains(nums[i])){
            dfs(i + 1, list, set);
        } 
    }
}
