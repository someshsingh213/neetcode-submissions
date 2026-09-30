class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, List<int []>> map = new HashMap<>();

        for(int i = 0; i<points.length; i++) {
            for(int j = 0; j<points.length; j++){
                if(i == j){
                    continue;
                }
            if(map.containsKey(i)){

            } else {
                map.put(i, new ArrayList<>());
            }
            map.get(i).add(new int [] {j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }

        PriorityQueue<int[]> minHeap =
        new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        List<int[]> list = map.get(0);
        HashSet<Integer> set = new HashSet<>();
        if(list == null){

        } else {
            for(int [] vertex: list){
            minHeap.offer(new int [] {vertex[0], vertex[1], 0}); //to, distance, from
        }
        set.add(0);
        }
        

        int d = 0;
        while(!minHeap.isEmpty() && set.size() <= points.length - 1){
            int [] polled = minHeap.poll();
            int to = polled[0];
            if (set.contains(to)) continue;
            int distance = polled[1];
            d = d + distance;
            int from = polled[2];

            
            list = map.get(to);
            for(int [] vertex: list){
                if(set.contains(vertex[0])){
                    continue;
                }
            minHeap.offer(new int [] {vertex[0], vertex[1], to}); //to, distance, from
        }
        set.add(to);
        }

        return d;
    }
}
