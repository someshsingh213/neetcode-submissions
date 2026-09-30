class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double [][] posTimePairs = new double [position.length][2];
        for(int i = 0; i<position.length; i++){
            posTimePairs[i] = new double [] {position[i], ((target - position[i]) * 1.0)/speed[i]};
        }
        Arrays.sort(posTimePairs, (a, b) -> Double.compare(a[0], b[0]));

        Stack<double []> stack = new Stack<>(); //index, time
        for(int i = speed.length - 1; i>=0; i--){
            double time = posTimePairs[i][1];

            if(stack.isEmpty() || stack.peek()[1] >= time){
                if(!stack.isEmpty()){
                    time = stack.pop()[1];
                }
            }
            stack.push(new double [] {i, time});
        }
        return stack.size();
    }
}
