class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> leftStack = new Stack();
        Stack<Integer> rightStack = new Stack();

        int maxArea = 0;

        int [] leftSmallerValueFromIthIndex = new int[heights.length];
        int [] rightSmallerValueFromIthIndex = new int[heights.length];

        //calculate leftSmallerValueFromIthIndex

        for(int i = 0; i<heights.length; i++) {
            while(!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]){
                leftStack.pop();
            }
            if(!leftStack.isEmpty() && heights[leftStack.peek()] < heights[i]){
                leftSmallerValueFromIthIndex[i] = leftStack.peek();
            } else {
                leftSmallerValueFromIthIndex[i] = -1;
            }
            leftStack.push(i);
        }

        //calculate rightSmallerValueFromIthIndex
        for(int i = heights.length - 1; i>=0; i--){
            while(!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[i]){
                rightStack.pop();
            }
            if(!rightStack.isEmpty() && heights[rightStack.peek()] < heights[i]){
                rightSmallerValueFromIthIndex[i] = rightStack.peek();
            } else {
                rightSmallerValueFromIthIndex[i] = heights.length;
            }
            rightStack.push(i);
        }

        //calculate maxArea
        for(int i = 0; i<heights.length; i++){
            maxArea = Math.max(maxArea, heights[i] * ((rightSmallerValueFromIthIndex[i] - 1) - (leftSmallerValueFromIthIndex[i] + 1) + 1));
        }

        return maxArea;
    }
}
