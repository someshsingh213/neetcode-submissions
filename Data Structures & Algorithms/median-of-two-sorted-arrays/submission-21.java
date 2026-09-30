class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        //at this stage nums1 is smaller and nums2 is bigger

        int total = nums1.length + nums2.length;
        int half = (total + 1)/2;
        int l = 0;
        int r = nums1.length;

        while(r >= l) {
            int midX = l + (r - l)/2;
            int midY = half - midX;
            
            int leftXMax = midX == 0 ? Integer.MIN_VALUE : nums1[midX - 1];
            int rightXMin = midX == nums1.length ? Integer.MAX_VALUE: nums1[midX];
            int leftYMax = midY == 0 ? Integer.MIN_VALUE : nums2[midY - 1];
            int rightYMin = midY == nums2.length ? Integer.MAX_VALUE : nums2[midY];

            if(leftXMax <= rightYMin && leftYMax <= rightXMin){
                if(total%2 == 0){
                    return (Math.max(leftXMax, leftYMax)*1.0 + Math.min(rightXMin, rightYMin))/2;
                } else {
                    return Math.max(leftXMax, leftYMax);
                }
            } else if(leftXMax > rightYMin){
                r = midX - 1;
            } else {
                l = midX + 1;
            }
        }

        return -1;
    }
}
