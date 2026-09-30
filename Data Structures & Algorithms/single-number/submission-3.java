class Solution {
    public int singleNumber(int[] nums) {
        /*
        run a for loop through each number:
        do bitwise 

        */
        int res = 0;
        for(int i = 0; i<nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;

    }
}
