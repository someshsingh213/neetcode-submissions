class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int ke = 0;

    public KthLargest(int k, int[] nums) {
        ke = k;
        for (int num : nums) heap.offer(num);

        for(int i = 0; i<nums.length - k; i++){ //(n-k)(log n)
            heap.poll(); 
        }
    }
    
    public int add(int val) {
        heap.offer(val);
    if (heap.size() > ke) heap.poll();
    return heap.peek();
    }
}
