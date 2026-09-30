class Solution {
    public int swimInWater(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int [][] distance = new int [R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = grid[0][0];
        PriorityQueue<int[]> minHeap = 
        new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        minHeap.offer(new int [] {0, 0, grid[0][0]});

        int [][] directions = new int [][] {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        while(!minHeap.isEmpty()) {
            int [] polled = minHeap.poll();
            int r = polled[0];
            int c = polled[1];
            int d = polled[2];

            if(d > distance[r][c]){
                continue;
            }

            for(int [] direction: directions){
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                    int newMax = Math.max(grid[nr][nc], d);
                    if(newMax < distance[nr][nc]) {
                        distance[nr][nc] = newMax;
                        minHeap.offer(new int [] {nr, nc, newMax});
                    }
                }
            }
        }

        return distance[R-1][C-1];
    }
}
