class Solution {
    public int search(int[] nums, int target) {
        int l = 0; 
        int r = nums.length - 1;
        int mid;
        while(r > l) {
            mid = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int smallestIndex = l;
        l = smallestIndex;
        r = nums.length - 1;
        
        while(r >= l){
            mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = 0;
        r = smallestIndex-1;

        while(r >= l){
            mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }
}
