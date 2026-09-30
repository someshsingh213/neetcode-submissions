class Solution {
    public boolean canJump(int[] nums) {
        //Go from back; goal is the nums.length - 1 th item
        //so start from nums.length - 2 th item, if it can reach nums.length - 1, 
        //the change goal to nums.length - 2 and so on until i = 0;

        int goal = nums.length - 1;
        for(int i = nums.length - 2; i >=0; i--){
            if(nums[i] + i >= goal){
                goal = i;
            }
        }

        if(goal == 0){
            return true;
        }
        return false;
    }
}
