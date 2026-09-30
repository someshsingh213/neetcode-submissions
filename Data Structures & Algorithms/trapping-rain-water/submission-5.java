class Solution {
    public int trap(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxLeft = height[leftPointer];
        int maxRight = height[rightPointer];
        int area = 0;
        while(leftPointer<rightPointer){
            if(maxLeft<maxRight){
                leftPointer++;
                maxLeft = Math.max(maxLeft, height[leftPointer]);
                if(Math.min(maxLeft, maxRight) - height[leftPointer] > 0){
                    area = area + Math.min(maxLeft, maxRight) - height[leftPointer];
                }
            } else {
                rightPointer--;
                maxRight = Math.max(maxRight, height[rightPointer]);
                if(Math.min(maxLeft, maxRight) - height[rightPointer] > 0){
                    area = area + Math.min(maxLeft, maxRight) - height[rightPointer];
                }
            }
        }
        return area;
    }
}
