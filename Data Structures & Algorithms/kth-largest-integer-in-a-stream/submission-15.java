class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int ke = 0;

    public KthLargest(int k, int[] nums) {
        ke = k;
        List<Integer> integerList = new ArrayList<>();

        for (int i : nums) {
            integerList.add(i); // Autoboxing converts int to Integer
        }
        heap = new PriorityQueue<>(integerList);
    }
    
    public int add(int val) {
        heap.offer(val);
    while(heap.size() > ke) heap.poll();
    return heap.peek();
    }
}
