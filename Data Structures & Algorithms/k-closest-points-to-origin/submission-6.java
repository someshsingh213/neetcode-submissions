class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //x,y coordinate in a 1d 2 value array, distance
PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
    Comparator.<int[]>comparingInt(p -> p[0] * p[0] + p[1] * p[1]).reversed()
);

        for (int[] p : points) {
            
    maxHeap.offer(p);
    if(maxHeap.size() > k){
                maxHeap.poll();
            }
}

    int [][] res = new int[k][2];
    int i = 0;
    while(!maxHeap.isEmpty()){
        res[i] = maxHeap.poll();
        i++;
    }

    return res;
    }
}
