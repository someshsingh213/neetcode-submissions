class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int longest = 0;
        for(int i =0; i<nums.length; i++){
            if(set.contains(nums[i] - 1)) {
                continue;
            } else {
                int length = 1;
                while(set.contains(nums[i]+length) && length<nums.length){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
