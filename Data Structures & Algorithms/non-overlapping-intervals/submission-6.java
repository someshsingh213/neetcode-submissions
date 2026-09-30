class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int prev = -1;
        int curr = 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        return intervals.length - dfs(intervals, curr, prev);
    }

    private int dfs(int [][] intervals, int current, int prev) {
        if(current == intervals.length){
            return 0;
        }
        int res = dfs(intervals, current + 1, prev);
        if(prev == -1 || !(intervals[current][0] < intervals[prev][1])) {
            res = Math.max(res, 1 + dfs(intervals, current + 1, current));
        }
        return  res;
    }
}
