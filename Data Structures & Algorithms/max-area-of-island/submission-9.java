class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int rowLen = grid.length;
        int colLen = grid[0].length;

        boolean [][] visited = new boolean[rowLen][colLen];
        boolean [][] isOne = new boolean[rowLen][colLen];

        for(int i = 0; i<rowLen; i++){
            for(int j = 0; j<colLen; j++){
                if(grid[i][j] == 1){
                    isOne[i][j] = true;
                }
            }
        }

        int max = 0;

        for(int i = 0; i<rowLen; i++){
            for(int j = 0; j<colLen; j++){
                if(isOne[i][j] && !visited[i][j]){
                    int count = 0;
                    q.offer(new int [] {i, j});
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int k = 0; k<size; k++){
                            int [] cell = q.poll();
                            int row = cell[0];
                            int col = cell[1];
                            if(visited[row][col]!=true){
                                count++;
                            }
                            visited[row][col] = true;
                            //left
                            if((col-1) > 0 && isOne[row][col-1] && !visited[row][col-1]){
                                q.offer(new int[] {row,col-1});
                            }
                            //right
                            if((col+1) < colLen && isOne[row][col+1] && !visited[row][col+1]){
                                q.offer(new int[] {row,col+1});
                            }
                            //top
                            if((row-1) > 0 && isOne[row-1][col] && !visited[row-1][col]){
                                q.offer(new int[] {row-1,col});
                            }
                            //bottom
                            if((row+1) < rowLen && isOne[row+1][col] && !visited[row+1][col]){
                                q.offer(new int[] {row+1,col});
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}
