class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] prefix = new int[nums.length];
        int [] suffix = new int[nums.length];

        int prefixProduct = 1;
        for(int i =0; i<nums.length; i++){
            prefix[i] = prefixProduct;
            prefixProduct = prefixProduct*nums[i];
        }
        
        int suffixProduct = 1;
        for(int i = nums.length - 1; i>=0; i--){
            suffix[i] = suffixProduct;
            suffixProduct = suffixProduct*nums[i];
        }

        int [] res = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            res[i] = suffix[i] * prefix[i];
        }
        return res;
    }
}  
