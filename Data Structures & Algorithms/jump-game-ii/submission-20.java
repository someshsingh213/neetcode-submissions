class Solution {

    public int jump(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int [] nums, int i) {

        if(i >= nums.length - 1) {
            return 0;
        }

        if(nums[i] == 0) {
            return Integer.MAX_VALUE;
        }
        
        int first = i+nums[i] == i ? Integer.MAX_VALUE: dfs(nums, i + nums[i]);
        int second = i+nums[i]-1 == i ? Integer.MAX_VALUE: dfs(nums, i + nums[i] - 1);

        return 1 + Math.min(first, second);
    }

}