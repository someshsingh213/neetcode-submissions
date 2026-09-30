class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        int j = 0;

        while(i < nums1.length || j <nums2.length) {
            
            if(j >= nums2.length || ( i < nums1.length && nums1[i] <= nums2[j])) {
                minHeap.offer(nums1[i]);
                i++;
            } else {
                minHeap.offer(nums2[j]);
                j++;
            }

            if(minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }

        if(minHeap.size() == maxHeap.size()){
            return (((minHeap.poll()*1.0) + maxHeap.poll()) / 2);
        } else {
            if(minHeap.size() > maxHeap.size()){
                return minHeap.poll();
            } else {
                return maxHeap.poll();
            }
        }

    }
}
