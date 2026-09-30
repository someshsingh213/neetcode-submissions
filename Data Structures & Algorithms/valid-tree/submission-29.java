class Solution {
    int [][] edges;
    int n;
    Map<Integer, List<Integer>> map;
    boolean res;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        this.edges = edges;
        this.n = n;
        map = new HashMap<>();
        res = true;
        visited = new HashSet<>();
        if (edges.length != n - 1){
            return false;
        }

        for(int i = 0; i<edges.length; i++) {
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0], new ArrayList<>());
            }
            if(!map.containsKey(edges[i][1])){
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        dfs(0, -1);
        if(res == false){
            return false;
        } else {
            return visited.size() == n;
        }
    }

    void dfs(int i, int p) {
        if(visited.contains(i)){
            res = false;
            return;
        }

        visited.add(i);
        List<Integer> neighbors = map.get(i);
        if(neighbors != null) {
            for(int nei : neighbors){
            if(nei != p && !visited.contains(nei)){
                dfs(nei, i);
            } else if (nei != p && visited.contains(nei)) {
                res = false;
                return;
            }
        }
        }
    }
}
