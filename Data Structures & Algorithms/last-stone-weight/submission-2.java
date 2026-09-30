class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i<stones.length; i++){
            heap.add(stones[i]);
        }

        while(heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if(x == y){
                //
            } else {
                heap.offer(Math.abs(x-y));
            }
        }

        if(heap.size()== 0) {
            return 0;
        } else {
            return heap.peek();
        }
    }
}
