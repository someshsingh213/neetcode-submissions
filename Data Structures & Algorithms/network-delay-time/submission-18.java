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

        int totalTime = 0;
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, Integer> currentTimeToReachNode = new HashMap<>();
        queue.offer(new int[] {k, 0});
        currentTimeToReachNode.put(k,0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++){
                int[] visiting = queue.poll();
                List <int []> connectingNodes = adjacencyList.get(visiting[0]);
                if(connectingNodes == null || connectingNodes.size() == 0){
                    continue;
                }
                for(int[] pair : connectingNodes){
                    if((visiting[1] + pair[1]) < currentTimeToReachNode.getOrDefault(pair[0], Integer.MAX_VALUE)){
                        queue.offer(new int [] {pair[0], visiting[1] + pair[1]});
                    }
                    currentTimeToReachNode.put(pair[0], Math.min(visiting[1] + pair[1], currentTimeToReachNode.getOrDefault(pair[0], Integer.MAX_VALUE)));
                }
            }
        }

        int minTime = 0;
        if(currentTimeToReachNode.keySet().size() == n){
            for(int time: currentTimeToReachNode.values()) {
                if(time > minTime){
                    minTime = time;
                }
            }

            return minTime;
        }

        return -1;
        
    }
}
