class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List <int[]> list = new ArrayList<>();
        for(int i = 0; i<intervals.length; i++){
            if(newInterval!=null && intervals[i][0]>newInterval[1]){
                list.add(newInterval);
                list.add(intervals[i]);
                newInterval = null;
            } else if(newInterval == null || newInterval[0] > intervals[i][1]){
                list.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        if(newInterval!=null){
            list.add(newInterval);
        }

        int[][] arr = list.toArray(new int[list.size()][]);
        return arr;
    }
}
