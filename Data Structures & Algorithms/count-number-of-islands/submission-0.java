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
                if(visit.contains(i+","+j)){   
                } else {
                    if(grid[i][j] == '1'){
                        numOfIslands++;
                        dfs(visit, i, j, grid);
                    }
                }
            }
        }

        return numOfIslands;
    }

    public void dfs(HashSet<String> visit, int i, int j, char [][] grid){
        if(visit.contains(i+","+j)){
            return;   
                } 
        visit.add(i + "," + j);
        //left
        
        if((j-1) >= 0 && grid[i][j-1] == '1'){
            dfs(visit, i, j-1, grid);
        }
        //top
        if((i-1) >= 0 && grid[i-1][j] == '1'){
            dfs(visit, i-1, j, grid);
        }
        //right
        if((j+1) < grid[i].length && grid[i][j+1] == '1'){
            dfs(visit, i, j+1, grid);
        }
        //bottom
        if((i+1) < grid.length && (grid[i+1][j] == '1')){
            dfs(visit, i+1, j, grid);
        }
    }
}
