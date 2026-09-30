class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int [] sortedQueries = new int [queries.length];
        for(int i = 0; i<queries.length; i++){
            sortedQueries[i] = queries[i];
        }
        Arrays.sort(sortedQueries);
        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<int[]> minHeap =
    new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));

        

        int interval = 0;
        for(int i = 0; i<sortedQueries.length; i++){
            while(interval < intervals.length && intervals[interval][0] <= sortedQueries[i]){
                minHeap.offer(intervals[interval]);
                interval++;
            }

            while(!minHeap.isEmpty() && sortedQueries[i] > minHeap.peek()[1]){
                minHeap.poll();
            }

            if(!minHeap.isEmpty()){
                map.put(sortedQueries[i], minHeap.peek()[1] - minHeap.peek()[0] + 1);
            }
        }

        for(int i = 0; i<queries.length; i++){
            if(map.containsKey(queries[i])){
                queries[i] = map.get(queries[i]);
            } else {
                queries[i] = -1;
            }
        }
        
        return queries;
    }
}
