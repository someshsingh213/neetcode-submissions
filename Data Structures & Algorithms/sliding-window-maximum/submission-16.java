class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Deque<Integer> deq = new LinkedList<>();
        int [] res = new int [nums.length - k + 1];
        while(right < nums.length){
            while(!deq.isEmpty() && nums[deq.getLast()] < nums[right]){
                deq.removeLast();
            }
            deq.add(right);

            if (right+1>=k) {
                res[left] = nums[deq.getFirst()];
                left++;
            }

            if(deq.getFirst() < left){
                deq.removeFirst();
            }
            
            right++;
        }
        return res;
    }
}
