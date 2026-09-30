class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i<gas.length; i++){
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
        }
        
        if(totalCost>totalGas){
            return -1;
        }

        int fuel = 0;
        int startPoint = 0;

        for(int i = 0; i<gas.length; i++){
            if((fuel + gas[i]) < cost[i]){
                startPoint = i + 1;
                fuel = 0;
            } else {
                fuel = fuel + gas[i] - cost[i];
            }
            
        }

        return startPoint;
    }
}
