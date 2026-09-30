class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> opps = new Hashtable<>();
        for(int i = 0; i< nums.length ; i++){
            if(opps.get(target - nums[i]) != null){
                return new int[]{opps.get(target - nums[i]), i};
            } else {
                opps.put(nums[i],i);
            }
        }
        return new int[] {0,0};
    }
}
