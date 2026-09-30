class Solution {
    HashMap<Integer, Integer> memo1;
    HashMap<Integer, Integer> memo2;
    int [] nums;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        this.nums = nums;
        memo1 = new HashMap<>(); //index, cost
        memo2 = new HashMap<>(); //index, cost
        dfs(0, true, memo1); dfs(1, false, memo2);
        return Math.max(memo1.get(0), memo2.get(1));
    }

    public int dfs(int index, boolean startsFromBegin, HashMap<Integer, Integer> memo) {
        if(startsFromBegin && index >= nums.length - 1) {
            return 0;
        }

        if(!startsFromBegin && index >= nums.length) {
            return 0;
        }

        if(memo.get(index)!=null){
            return memo.get(index);
        }

        //choose index
        int chooseIndex = nums[index] + dfs(index + 2, startsFromBegin, memo);
        //don't choose index
        int notChooseIndex = dfs(index + 1, startsFromBegin, memo);
        memo.put(index, Math.max(chooseIndex, notChooseIndex));
        return Math.max(chooseIndex, notChooseIndex);

    }
}
