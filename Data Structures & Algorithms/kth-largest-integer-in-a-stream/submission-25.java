class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        this.k = k;
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
