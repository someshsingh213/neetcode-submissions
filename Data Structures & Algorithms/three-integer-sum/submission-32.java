class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0; i<nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(left<right){
                if(nums[i] + nums[left] + nums[right] > 0){
                    right --;
                    continue;
                } else if(nums[i] + nums[left] + nums[right] < 0){
                    left ++;
                    continue;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while(left <nums.length - 1 && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(right>1 && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
