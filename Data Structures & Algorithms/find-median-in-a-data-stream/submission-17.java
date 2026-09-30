class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if((maxHeap.size() > minHeap.size() + 1) || (maxHeap.size()!=0 && minHeap.size()!=0 && maxHeap.peek() > minHeap.peek())) {
            minHeap.offer(maxHeap.poll());
        }
        if((minHeap.size() > maxHeap.size() + 1)) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek()*1.0 + minHeap.peek())/2;
        }
    }
}
