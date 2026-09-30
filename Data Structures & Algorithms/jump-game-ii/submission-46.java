class Solution {
    public int jump(int[] nums) {
        int count = 0;
        for(int i = 0; i<nums.length; i++) {
            int [] maxInRange = new int[2];
            maxInRange = new int [] {nums[0],0};

            int left = i + 1;
            int right = i + nums[i];

            if(right<left || left >= nums.length){
                break;
            }
            if(right >= nums.length - 1) {
                count++;
                break;
            } else {
                int index = left;
                while(index <=right ) {
                    if(maxInRange[1] + maxInRange[0] < index + nums[index]){
                        maxInRange[0] = nums[index];
                        maxInRange[1] = index;
                    }
                    index++;
                }
            }
            count ++;
            i = maxInRange[1]; 
            i--;
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
