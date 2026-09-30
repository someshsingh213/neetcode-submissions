class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for(int i = 0; i<times.length; i++) {
            int source = times[i][0];
            int target = times[i][1];
            int time = times[i][2];
            if(!adjacencyList.containsKey(source)){
                adjacencyList.put(source, new ArrayList<>());
            }
            List<int []> newList = (adjacencyList.get(source));
            newList.add(new int[]{target, time});
        }

        PriorityQueue<int []> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int [] {k, 0});
        HashMap<Integer, Integer> finalTimeToReachNode = new HashMap<>();
        finalTimeToReachNode.put(k, 0);

        while(!minHeap.isEmpty()){
            int[] pair = minHeap.poll();
            List<int[]> adjacentNodes = adjacencyList.get(pair[0]);
            if(adjacentNodes == null || adjacentNodes.size() == 0){
                continue;
            }
            for(int[] p : adjacentNodes){
                if(finalTimeToReachNode.getOrDefault(p[0], Integer.MAX_VALUE) > (p[1] + pair[1])){
                    minHeap.offer(new int [] {p[0], p[1] + pair[1]});
                    finalTimeToReachNode.put(p[0], Math.min(finalTimeToReachNode.getOrDefault(p[0], Integer.MAX_VALUE), p[1] + pair[1]));
                }
        
                
            }
        }

        int minTime = 0;
        if(finalTimeToReachNode.keySet().size() == n) {
            for(int i: finalTimeToReachNode.values()){
                if(i>minTime){
                    minTime = i;
                }
            }
            return minTime;
        }

        return -1;
        
    }
}
