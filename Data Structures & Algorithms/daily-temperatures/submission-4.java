class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] arr = new int[temperatures.length];
        Stack<int []> stack = new Stack<>(); //[temp, index]

        for(int i = 0; i<temperatures.length; i++){
            // if(stack.isEmpty() || stack.peek()[0] >= temperatures[i]){
            //     stack.push(new int [] {temperatures[i], i});
            // }

            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int [] pair = stack.pop();
                arr[pair[1]] = i - pair[1];
            }
            stack.push(new int [] {temperatures[i], i});
        }

        return arr;
    }
}
