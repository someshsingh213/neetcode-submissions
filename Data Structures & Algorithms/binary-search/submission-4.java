class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int midIndex = (left+right) / 2;
        while(nums[midIndex] != target && right>left){
            if(nums[midIndex] > target){
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
            midIndex = (left+right) / 2;
        }

        if(nums[midIndex] == target){
            return midIndex;
        } else {
            return -1;
        }
        
    }
}
