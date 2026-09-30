class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;

        if(x > y) {
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        x = nums1.length;
        y = nums2.length;

        int l = 0;
        int r = nums1.length;

        while(r >= l) {
            int partitionX = l + (r-l)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x + y)%2 == 0){
                    return (Math.max(maxLeftY, maxLeftX) * 1.0 + Math.min(minRightY, minRightX))/2;
                }
                else {
                    return Math.max(maxLeftY, maxLeftX);
                }
            } else if(maxLeftX > minRightY) {
                r = partitionX - 1;
            } else {
                l = partitionX + 1;
            }
        }

        return 0;

    }
}
