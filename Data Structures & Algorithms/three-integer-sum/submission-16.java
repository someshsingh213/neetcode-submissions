class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i <nums.length-2; i++){
            // i;
            int leftPointer = i+1;
            int rightPointer = nums.length - 1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(leftPointer<rightPointer){
                if(nums[leftPointer]+nums[rightPointer] +nums[i] > 0){
                    rightPointer --;
                    continue;
                }
                if(nums[leftPointer]+nums[rightPointer] +nums[i] < 0){
                    leftPointer ++;
                    continue;
                }
                if(nums[leftPointer]+nums[rightPointer] +nums[i] == 0){
                    list.add(new ArrayList<>(Arrays.asList(nums[leftPointer], nums[rightPointer], nums[i])));
                    if(nums[leftPointer] == nums[leftPointer+1]){
                        leftPointer++;
                    }
                     if(nums[rightPointer] == nums[rightPointer-1]){
                        rightPointer--;
                    }
                    leftPointer++;
                    rightPointer--;
                }
            }
        }
        return list;
    }
}
