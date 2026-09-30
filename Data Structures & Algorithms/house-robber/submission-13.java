class Solution {

    int totalHouses;
    int [] wealth;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        totalHouses = nums.length;
        wealth = nums;
        return dfs(0);
    }

    public int dfs(int house){
        if(house >= totalHouses){
            return 0;
        }
        int sum;
        if(map.containsKey(house)){
            sum = map.get(house);
        } else {
            sum = Math.max(wealth[house] + dfs(house+2), dfs(house+1));
            map.put(house, sum);
        }
        return sum;
    }
}
