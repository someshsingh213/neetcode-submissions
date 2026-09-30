class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int []> arrayList = new ArrayList<>(Arrays.asList(intervals));
        int prevEnd = intervals[0][1];
        int[] prev = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] < prevEnd){
                if(intervals[i][1] > prevEnd){
                    arrayList.remove(intervals[i]);
                } else {
                    arrayList.remove(prev);
                    prev = intervals[i];
                    prevEnd = intervals[i][1];
                }
            } else {
                prev = intervals[i];
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - arrayList.size();
    }
}
