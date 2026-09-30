class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort by start time (interval[0])
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
int [] sortedQueries = new int [queries.length];

for(int i = 0; i<queries.length; i++){
    sortedQueries[i] = queries[i];
}

Arrays.sort(sortedQueries);
PriorityQueue<int[]> minHeap = new PriorityQueue<>(
    (a, b) -> {
        
        int rangeA = a[1] - a[0] + 1;
        int rangeB = b[1] - b[0] + 1;
        return Integer.compare(rangeA, rangeB); // smaller range if same start
    }
);
int interval = 0;
HashMap<Integer, Integer> map = new HashMap<>();
for(int i = 0; i<sortedQueries.length; i++){

    //if interval has started
    while(interval < intervals.length && sortedQueries[i] >= intervals[interval][0]){
        minHeap.offer(intervals[interval]);
        interval++;
    }

    while(!minHeap.isEmpty() && minHeap.peek()[1]<sortedQueries[i]){
        minHeap.poll();
    }

    if(!minHeap.isEmpty()){
        map.put(sortedQueries[i], minHeap.peek()[1] - minHeap.peek()[0] + 1);
    } else {
        map.put(sortedQueries[i], -1);
    }
}

for(int i = 0; i<queries.length; i++){
    queries[i] = map.get(queries[i]);
}
return queries;
    }
}
