class Solution {
    public int swimInWater(int[][] grid) {
        int [][] distance = new int [grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> minHeap =
    new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
    distance[0][0] = grid[0][0];
    minHeap.offer(new int [] {0, 0, distance[0][0]});

    int [][] directions = new int [][] {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    while(!minHeap.isEmpty()) {
        int [] polled = minHeap.poll();
        int r = polled[0];
        int c = polled[1];
        int smallestMaxUntilRC = polled[2];

        // if(smallestMaxUntilRC > distance[r][c]){
        //     continue;
        // }

        for(int [] direction: directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if(nr < 0 || nc <0 || nr >= grid.length || nc>= grid[0].length) {
                continue;
            }
            int newSmallestMaxUntilNRNC = Math.max(grid[nr][nc], smallestMaxUntilRC);
            if (newSmallestMaxUntilNRNC < distance[nr][nc]) {
                distance[nr][nc] = newSmallestMaxUntilNRNC;
                minHeap.offer(new int [] {nr, nc, newSmallestMaxUntilNRNC});
            }
        }
    }

    return distance[grid.length - 1][grid[0].length - 1];
    }
}
