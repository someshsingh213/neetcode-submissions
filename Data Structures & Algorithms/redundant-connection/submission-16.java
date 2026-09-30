class Solution {
    Map<Integer, Set<Integer>> adjacencyList;
    Map<Integer, Set<Integer>> map;
    Set<Integer> visited;
    Set<Integer> cycle;
    List<Integer> cycleList;
    int n;
    int startOfList;
    public int[] findRedundantConnection(int[][] edges) {
        adjacencyList = new HashMap<>();
        map = adjacencyList;
        n = edges.length;
        visited = new HashSet<>();
        cycle = new HashSet<>();
        cycleList = new ArrayList<>();
        startOfList = 0;
        for(int [] edge: edges) {
            int i = edge[0];
            int j = edge[1];

            if(!map.containsKey(i)){
                map.put(i, new HashSet<>());
            }

            if(!map.containsKey(j)){
                map.put(j, new HashSet<>());
            }

            map.get(i).add(j);
            map.get(j).add(i);
        }

        dfs(1, 0);

        int startIndex = -1;
        for(int z = 0; z <cycleList.size(); z++){
            if(cycleList.get(z) == startOfList){
                startIndex = z;
                break;
            }
        }

        Set<Integer> newCycle = new HashSet<>();
        for(int z = startIndex; z <cycleList.size(); z++){
            newCycle.add(cycleList.get(z));
        }

        cycle = newCycle;

        for(int k = edges.length - 1; k >= 0; k--) {
            int i = edges[k][0];
            int j = edges[k][1];

            if(cycle.contains(i) && cycle.contains(j)){
                return edges[k];
            }
        }

        return new int [] {0,0};
    }

    boolean dfs(int i, int p) {
        if(i > n) {
            return true;
        }

        if(visited.contains(i)){
            return true;
        }

        if(cycle.contains(i)){
            startOfList = i;
            return false;
        }

        cycle.add(i);
        cycleList.add(i);
        Set<Integer> neighbors = map.get(i);
        for(int neighbor: neighbors){
            if(p == neighbor){
                continue;
            }
            if(dfs(neighbor, i) == false){
                return false;
            }
        }

        cycle.remove(i);
        cycleList.removeLast();
        visited.add(i);
        return true;
    }
    
}
