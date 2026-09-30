class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int ke = 0;

    public KthLargest(int k, int[] nums) {
        ke = k;
        for (int num : nums) heap.offer(num);
    }
    
    public int add(int val) {
        heap.offer(val);
    while(heap.size() > ke) heap.poll();
    return heap.peek();
    }
}
