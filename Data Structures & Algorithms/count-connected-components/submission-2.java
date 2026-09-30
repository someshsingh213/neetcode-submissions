class Solution {
    HashMap<Integer, List<Integer>> map;
    Set<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        visited = new HashSet<>();
        for(int [] edge: edges) {
            int x = edge[0];
            int y = edge[1];

            if(!map.containsKey(x)){
                map.put(x, new ArrayList<>());
            }
            if(!map.containsKey(y)){
                map.put(y, new ArrayList<>());
            }

            map.get(x).add(y);
            map.get(y).add(x);
        }

        int count = 0;
        for(int i = 0; i<n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(i, -1);
            }
        }

        return count;
    }

    void dfs(int i, int p) {
        if(visited.contains(i)){
            return;
        }

        visited.add(i);

        List<Integer> neighbors = map.get(i);
        if(neighbors!=null){
            for(int nei: neighbors){
                if(nei!=p && !visited.contains(nei)){
                    dfs(nei, i);
                }
            }
        }
    }
}
