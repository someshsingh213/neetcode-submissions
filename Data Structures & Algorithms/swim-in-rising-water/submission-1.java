
public class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;

        int[][] dist = new int[N][N];
        for (int r = 0; r < N; r++) {
            Arrays.fill(dist[r], Integer.MAX_VALUE);
        }

        // dist[r][c] = minimum possible "max height so far" to reach (r,c)
        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // {cost, r, c}
        pq.offer(new int[]{dist[0][0], 0, 0});

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], r = curr[1], c = curr[2];

            // Classic Dijkstra: ignore stale entries
            if (cost > dist[r][c]) continue;

            // Early exit: first time we finalize target is optimal
            if (r == N - 1 && c == N - 1) return cost;

            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                int newCost = Math.max(cost, grid[nr][nc]); // relaxation rule
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.offer(new int[]{newCost, nr, nc});
                }
            }
        }

        return -1; // unreachable (won't happen for valid input)
    }
}