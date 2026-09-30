class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> rep = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(rep.contains(nums[i])){
                return true;
            } else {
                rep.add(nums[i]);
            }
        }
        return false;
    }
}