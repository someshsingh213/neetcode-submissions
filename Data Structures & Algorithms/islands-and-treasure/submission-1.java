class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue <int []> q = new LinkedList<>();
        Queue <int []> queue = q;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 0){
                    q.add(new int [] {i, j});
                }  
            }
        }

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                while(!q.isEmpty()){
                    int len = q.size();
                    for(int k = 0; k <len; k++ ){
                        int [] pair = q.poll();

                        int rowIndex = pair[0], colIndex = pair[1];
                        //left
                        colIndex = pair[1] - 1;
                        rowIndex = pair[0];
                        if(colIndex >= 0 && grid[rowIndex][colIndex] == 2147483647){
                            grid[rowIndex][colIndex] = grid[pair[0]][pair[1]] + 1;
                            queue.add(new int[] {rowIndex, colIndex});
                        }
                        //right
                        colIndex = pair[1] + 1;
                        rowIndex = pair[0];
                        if(colIndex < cols && grid[rowIndex][colIndex] == 2147483647){
                            grid[rowIndex][colIndex] = grid[pair[0]][pair[1]] + 1;
                            queue.add(new int[] {rowIndex, colIndex});
                        }
                        //top
                        colIndex = pair[1];
                        rowIndex = pair[0] - 1;
                        if(rowIndex >= 0 && grid[rowIndex][colIndex] == 2147483647){
                            grid[rowIndex][colIndex] = grid[pair[0]][pair[1]] + 1;
                            queue.add(new int[] {rowIndex, colIndex});
                        }
                        //down
                        colIndex = pair[1];
                        rowIndex = pair[0] + 1;
                        if(rowIndex < rows && grid[rowIndex][colIndex] == 2147483647){
                            grid[rowIndex][colIndex] = grid[pair[0]][pair[1]] + 1;
                            queue.add(new int[] {rowIndex, colIndex});
                        }
                    }
                }
            }
        }
    }
}
