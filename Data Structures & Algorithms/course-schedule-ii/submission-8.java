class Solution {
    Set<Integer> visited;
    List<Integer> res;
    Set<Integer> resSet;
    Map<Integer, List<Integer>> adjacencyList;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create adjancency list
        adjacencyList = new HashMap<>();
        for(int i = 0; i<prerequisites.length; i++){
            int [] pair = prerequisites[i];
            if(adjacencyList.containsKey(pair[0])){

            } else {
                adjacencyList.put(pair[0], new ArrayList<>());
            }
            adjacencyList.get(pair[0]).add(pair[1]);
        }

        visited = new HashSet<>();
        for(int i = 0; i <numCourses; i++){
            if(adjacencyList.get(i) == null){
                visited.add(i);
            }
        }

        res = new ArrayList<>();
        resSet = new HashSet<>();
        for(int i = 0; i <numCourses; i++){
            if(dfs(i, new HashSet<>()) == false) {
                return new int [] {};
            }
        }

        int len = res.size();
        int[] result = new int[len];
        for(int i = 0; i<len; i++){
            result[i] = res.get(i);
        }
        return result; 
    }

    boolean dfs(int i, Set<Integer> visiting) {
        if(visited.contains(i)){
            if(resSet.contains(i)){
            } else {
                res.add(i);
                resSet.add(i);
            }
            return true;
        }

        if(visiting.contains(i)){
            return false;
        }
        visiting.add(i);
        for(int child: adjacencyList.get(i)) {
            if(dfs(child, visiting) == false){
                return false;
            }
        }
        res.add(i);
        resSet.add(i);
        visited.add(i);
        return true;
    }
    
}
