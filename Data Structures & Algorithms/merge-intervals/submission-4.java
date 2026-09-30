class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
    if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]); // sort by start time
    }
    return Integer.compare(a[1], b[1]);     // then by end time
});

        for(int i = 0; i<intervals.length - 1; i++){
            int [] firstInterval = intervals[i];
            int [] secondInterval = intervals[i+1];

            if(firstInterval[1] < secondInterval[0]){
                list.add(firstInterval);
            } else {
                intervals[i+1][0] = Math.min(firstInterval[0], secondInterval[0]);
                intervals[i+1][1] = Math.max(firstInterval[1], secondInterval[1]);
            }

        }

        list.add(intervals[intervals.length - 1]);
        return list.toArray(new int[list.size()][]);
    }
}
