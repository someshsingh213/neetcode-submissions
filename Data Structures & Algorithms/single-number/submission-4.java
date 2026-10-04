class Solution {
    public int singleNumber(int[] nums) {
        //3, 2, 3 => 11, 10, 11
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum = sum ^ nums[i];
        }
        return sum;
    }
}
