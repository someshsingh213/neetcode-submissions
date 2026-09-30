class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // //brute force solution is checking every array and computing the list 
        // // of courses that you have to take. If that list contains the course that
        // // I'm checking, that means there is a cycle, otherwise, keep going
        // // do this for every course pair. In worst case, this would be O(prerequisitees^2) cause
        // //if any course is not there in the preqreqsite, that means we can just assume
        // // that there is no prereq for it, and for anything that has a prereq, that will
        // // be covered by traversing the pre-requisites array. 

        // [0,1] [2,3] [2,4] [0,4] [1,3]

        // Take 0 -> its dependent on 1
        // Take 1 -> its dependent on 3
        // Take 3 -> its dependent on

        // For worst case, for every pair in PreReqArray, you will have to traverse the PreReqArray numOfCourses times.
        // for every pair in prereqaray{
        //     traverse the course {
        //         traverse the prereqaray array{}
        //     }
        // }
        // so worst case complexity becomes O(sizeOfPreReqArray^2 * numOfCourses)

        //adjacency list
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i<prerequisites.length; i++) {
            if(adjacencyList.containsKey(prerequisites[i][0])) {
                
            } else {
                adjacencyList.put(prerequisites[i][0], new ArrayList<Integer>());
            }
            (adjacencyList.get(prerequisites[i][0])).add(prerequisites[i][1]);
        }

//numCourses=4
//prerequisites=[[2,0],[1,0],[3,1],[3,2],[1,3]]
    //2 -> [0]
    //1 -> [0,3]
    //3 -> [1,2]

        
        for (int i = 0; i<numCourses; i++) { 
            HashSet<Integer> dfsCycle = new HashSet<>();

            // 
            if(!dfs(i, adjacencyList, dfsCycle)){
                return false;
            }
        }

        return true;
    }

    boolean dfs(int course, HashMap<Integer, List<Integer>> adjacencyList, HashSet<Integer> dfsCycle) {
        if(dfsCycle.contains(course)){
                return false;
            }
            if(adjacencyList.get(course) == null) {
            return true;
        }
            dfsCycle.add(course);
        
        for(int c: adjacencyList.get(course)) {
             
                if(!dfs(c, adjacencyList, dfsCycle)) {
                    return false;
                }
        }
        dfsCycle.remove(course); // critical backtrack
        return true;
    }
}
