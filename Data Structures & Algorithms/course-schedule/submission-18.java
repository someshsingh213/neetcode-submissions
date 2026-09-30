class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create adjacency list
        HashMap<Integer, List<Integer>> adjacencyListMap = new HashMap<>();
        for(int[] pair: prerequisites){
            if(adjacencyListMap.containsKey(pair[0])){

            } else {
                adjacencyListMap.put(pair[0], new ArrayList<>());
            }
            adjacencyListMap.get(pair[0]).add(pair[1]);
        }

        for(int i = 0; i<numCourses; i++) {
            HashSet<Integer> dfsCycle = new HashSet<>();
            if(!dfs(i, dfsCycle, adjacencyListMap)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course, HashSet<Integer> dfsCycle, HashMap<Integer, List<Integer>> adjacencyListMap){
        if(dfsCycle.contains(course)){
            return false; //cycle
        }
        if(adjacencyListMap.get(course)==null){
            return true;
        }
        dfsCycle.add(course);
        for(int c: adjacencyListMap.get(course)){
            if(!dfs(c, dfsCycle, adjacencyListMap)){
                return false;
            }
        }
        dfsCycle.remove(course);
        return true;
    }
}
