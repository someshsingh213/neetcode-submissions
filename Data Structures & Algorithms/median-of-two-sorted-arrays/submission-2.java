class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] nums = new int [nums1.length + nums2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] >= nums2[j]){
                nums[k] = nums2[j];
                j++;
                
            } else {
                nums[k] = nums1[i];
                i++;
            }
            k++;
        }

        while(i < nums1.length){
            nums[k] = nums1[i];
            k++;
            i++;
        }

        while(j < nums2.length){
            nums[k] = nums2[j];
            k++;
            j++;
        }

        int length = nums.length;
        if(length%2 == 0){
            return ((nums[length/2 - 1]*1.0) + nums[length/2])/2;
        } else {
            return nums[length/2];
        }
    }
}
