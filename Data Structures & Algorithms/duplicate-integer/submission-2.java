class Solution {
    public boolean hasDuplicate(int[] nums) {
        int len = nums.length;
        List<Integer> rep = new ArrayList<>();
        for(int i  = 0; i <=len - 1; i++){
            if(rep.contains(nums[i])){
                return true;
            } else {
                rep.add(nums[i]);
            }
        }
        return false;
    }
}