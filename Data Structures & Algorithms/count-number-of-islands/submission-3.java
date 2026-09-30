class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
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
        if((j) < 0 
        || (i) < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'
        || visit.contains(i+","+j)){
            return;   
            } 

        visit.add(i + "," + j);


            dfs(visit, i, j-1, grid);
            dfs(visit, i-1, j, grid);
            dfs(visit, i, j+1, grid);
            dfs(visit, i+1, j, grid);
    }
}
