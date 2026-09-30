class Solution {
    public int search(int[] nums, int target) {
        //int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        //return new int[2] {left, right};
        return right;
    }

    int binarySearch(int [] nums, int target, boolean isLeftMost){

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        int found = -1;

        while(left <= right){
            mid = left + (right - left)/2;
            if(target > nums[mid]){
                left = mid + 1;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                found = mid;
                if(isLeftMost){
                    if(mid!=0 && nums[mid-1] == target){
                    right = mid - 1;
                } else {
                    break;
                }
                } else {
                    if(mid!=nums.length -1 && nums[mid+1] == target){
                        left = mid + 1;
                    } else {
                        break;
                    }
                }  
            }
        }

        return found;
    }
}
