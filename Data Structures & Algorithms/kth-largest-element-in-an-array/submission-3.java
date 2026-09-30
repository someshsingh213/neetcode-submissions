class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        Iterate through all elements of nums. O(n) time
        Put elements in a min heap until we get to k elements(O(k) space)
        Once heap size becomes larger than k, remove smallest element (O(log k) time)
        Once all elements are done, largest k elements remain
        remove the smallest element which is O(1) operation
        Total time complexity = O(nlogk)
        Total space = O(k)
        */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            minHeap.offer(nums[i]); //  5, 4
            if(!(minHeap.size() <= k)){
                minHeap.poll();
            } 
        }
        return minHeap.peek();
    }
}
