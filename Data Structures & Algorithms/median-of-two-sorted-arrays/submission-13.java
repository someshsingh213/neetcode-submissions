class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        //Binary search on nums1
        int l = 0;
        int r = nums1.length;

        while(l <= r) {
            int partitionX = l + (r-l)/2; //mid
            int partitionY = (nums1.length + nums2.length + 1)/2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((nums1.length + nums2.length)%2 == 0){
                    return (Math.max(maxLeftX, maxLeftY)*1.0 + Math.min(minRightX, minRightY)) /2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                r = partitionX - 1;
            } else if (maxLeftY > minRightX) {
                l = partitionX + 1; 
            }
        }

        return 0;
    }
}
