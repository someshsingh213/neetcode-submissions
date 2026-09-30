class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int i = 0;
        while(i<nums.length - 1) {
            int [] maxInRange = new int [] {nums[i] + i,i};

            int left = i + 1;
            int right = i + nums[i];
            if (nums[i] == 0) return Integer.MAX_VALUE;
            if(right >= nums.length - 1) {
                return ++count;
            } else {
                for(int index = left; index <= Math.min(right, nums.length - 1); index++) {
                    if(maxInRange[0] < index + nums[index]){
                        maxInRange[0] = nums[index] + index;
                        maxInRange[1] = index;
                    }
                }
            }
            count ++;
            i = maxInRange[1]; 
        }
        return count;
        /*
        count = 0;
        For every index i:
            int maxInRange = int [2 -> value, index];
            if(num[i] == 0) {
                return MAX_VALUE;
            }
            left = i + 1;
            right = i + num[i].
            if(right > = length - 1){
                exit;
            } else {
                for(index >= left until index <=right ){
                    if(maxInRange[0] < nums[index]){
                        maxInRange[0] = nums[index];
                        maxInRange[1] = index;
                    }
                    index++;
                } 
            }
            count++;
            i = maxInRange[1]

        return count;
        */
    }
}
