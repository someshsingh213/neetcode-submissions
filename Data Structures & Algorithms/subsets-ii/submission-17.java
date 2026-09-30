class Solution {
    List<List<Integer>> res;
    int len;
    int [] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        len = nums.length;
        
        this.nums = nums;
        Arrays.sort(this.nums);
        dfs(0, new ArrayList<>());
        return res;
    }

    void dfs(int i, List<Integer> list) {

        if(i >= len) {
            res.add(new ArrayList<>(list));
            return;
        }
        //choose i
        
        list.add(nums[i]);
        dfs(i+1,list);
       
        list.removeLast();
        //don't choose i
            while(i+1 < len && nums[i+1] == nums[i]){
                i++;
            }
            dfs(i + 1, list);
    }
}
