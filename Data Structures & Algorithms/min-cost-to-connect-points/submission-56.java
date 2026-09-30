class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = 
        new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        Map<Integer, List<int []>> map = new HashMap<>();

        //create adjancency list
        for(int i = 0; i<points.length; i++){
            for(int j = 0; j<points.length; j++){
                if(i == j){
                    continue;
                }
                if(!map.containsKey(i)){
                    map.put(i, new ArrayList<>());
                }
                map.get(i).add(new int [] {j, (Math.abs(points[j][0] - points[i][0]) + Math.abs(points[i][1] - points[j][1]) )});
            }
        }

        //add all elements that are from 0 to the adjancency list for the first pop
        List<int []> edgesFromZero = map.get(0);
        if(edgesFromZero!=null){
            for(int [] pair: edgesFromZero) {
            minHeap.offer(new int [] {0, pair[0], pair[1]});
        }
        }
        

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int totalDistance = 0;
        while(!minHeap.isEmpty() && visited.size() < points.length){
            int [] pair = minHeap.poll();
            int from = pair[0];
            int to = pair[1];
            int distance = pair[2];

            if(visited.contains(to)){
                continue;
            }

            totalDistance = totalDistance + distance;
            List<int []> edgesFromTo = map.get(to);
        for(int [] pair1: edgesFromTo) {
            minHeap.offer(new int [] {to, pair1[0], pair1[1]});
        }
            visited.add(to);
        }

        return totalDistance;
    }
}
