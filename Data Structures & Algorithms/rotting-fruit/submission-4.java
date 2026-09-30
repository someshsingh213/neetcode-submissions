class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j =0; j<grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int [] {i, j});
                }
            }
        }
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i <size; i++){
                int[] rotten = q.poll();
                int rottenRow = rotten[0];
                int rottenCol = rotten[1];
                
                //up
                if(rottenRow - 1 >= 0 && grid[rottenRow - 1][rottenCol] == 1){
                    grid[rottenRow-1][rottenCol] = 2;
                    q.offer(new int [] {rottenRow-1, rottenCol});
                } 
                //down
                if(rottenRow + 1 < grid.length && grid[rottenRow + 1][rottenCol] == 1){
                    grid[rottenRow+1][rottenCol] = 2;
                    q.offer(new int [] {rottenRow+1, rottenCol});
                } 
                //left
                if(rottenCol - 1 >= 0 && grid[rottenRow][rottenCol - 1] == 1){
                    grid[rottenRow][rottenCol-1] = 2;
                    q.offer(new int [] {rottenRow, rottenCol-1});
                } 
                //right
                if(rottenCol + 1 < grid[0].length && grid[rottenRow][rottenCol + 1] == 1){
                    grid[rottenRow][rottenCol+1] = 2;
                    q.offer(new int [] {rottenRow, rottenCol+1});
                }
            }
            time++;
        }

        for(int i = 0; i<grid.length; i++){
            for(int j =0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return time == 0 ? 0 : time -1;
        
    }
}
