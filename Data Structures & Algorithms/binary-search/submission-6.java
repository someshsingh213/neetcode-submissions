class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        int leftMost = -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(target > nums[mid]){
                left = mid + 1;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                if(mid!=0 && nums[mid-1] == target){
                    right = mid - 1;
                    leftMost = mid;
                } else {
                    leftMost = mid;
                    break;
                }
            }
        }

        return leftMost;
    }
}
