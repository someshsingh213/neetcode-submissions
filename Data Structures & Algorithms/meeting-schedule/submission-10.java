/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start)); //nlogn
        int start = 0;
        int end = 0;
        for(int i = 0; i<intervals.size(); i++){
            if(intervals.get(i).start<end){
                return false;
            } else {
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        return true;
    }
}
