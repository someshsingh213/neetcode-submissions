class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int left = 0;
        int right = left + k - 1; //inclusive
        int [] res = new int [nums.length - k + 1];
        int resIndex = 0;
        while(right<nums.length){
            int max = nums[left];
            int maxIndex = left;
            for(int i = left; i<=right; i++){
                max = Math.max(max, nums[i]);
                maxIndex = left;
            }
            res[resIndex] = max;
            left++;
            right++;
            resIndex++;
        }

        return res;
    }
}
