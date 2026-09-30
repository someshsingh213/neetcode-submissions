class Solution {
    HashMap<String, Integer> map; //[currSum, i] -> ways 
    //with currSum starting at index i, there are ways to sum to target
    int [] nums;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        this.nums = nums;
        this.target = target;
        return dfs(0,0);//sum, index
        //return map.get(new int [] {0,0});
    }

    int dfs(int currSum, int i) {
         String key = currSum + "," + i;
        if(i == nums.length){
            if(currSum == target){
                map.put(key, 1);
            return 1;
        }
        map.put(key, 0);
            return 0;
        }
        


        if(map.containsKey(key)) {
            return map.get(key);
        }

        map.put(key, dfs(currSum + nums[i], i+1) + dfs(currSum - nums[i], i+1));

        return map.get(key);
    }
}
