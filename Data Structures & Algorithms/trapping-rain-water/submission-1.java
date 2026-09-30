class Solution {
    public int trap(int[] height) {
        int [] leftMax = new int[height.length];
        int [] rightMax = new int[height.length];

        int left = 0;
        int right = 0;
        for(int i =0; i<height.length; i++){
            left = Math.max(left, height[i]);
            leftMax[i] = left;
        }

        for(int i = height.length - 1; i>=0; i--){
            right = Math.max(right, height[i]);
            rightMax[i] = right;
        }

        int area = 0;
        for(int i = 0; i<height.length; i++){
            if(Math.min(leftMax[i], rightMax[i]) - height[i] > 0){
                area = area + Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            
        }

        return area;
    }
}
