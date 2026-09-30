class Solution {
    int numOfIslands = 0;
    public int numIslands(char[][] grid) {
        //from each 1, see neighbor (top, bottom, left, right)
        //put that in visited
            //if 1 at any neighbor -> combine those 1s and see neighbor of that 1(Except visted)
                //once you read nothing but 0s, add result by one
                //if you get a zero go to the next one


                // visit set needs to be global for all dfs runs
                // increase result by one only once a dfs and its neighbors dfs is over
                // i.e. when new dfs run is run from the grid and not by recrusion.
        HashSet<String> visit = new HashSet<>();
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(!visit.contains(i+","+j) && grid[i][j] == '1'){   
                        numOfIslands++;
                        dfs(visit, i, j, grid);
                }
            }
        }

        return numOfIslands;
    }

    public void dfs(HashSet<String> visit, int i, int j, char [][] grid){
        if(visit.contains(i+","+j)  || (j) < 0 
        || (i) < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'){
            return;   
            } 

        visit.add(i + "," + j);


            dfs(visit, i, j-1, grid);
            dfs(visit, i-1, j, grid);
            dfs(visit, i, j+1, grid);
            dfs(visit, i+1, j, grid);
    }
}
