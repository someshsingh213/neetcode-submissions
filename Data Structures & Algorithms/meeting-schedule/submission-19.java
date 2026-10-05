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
        for(int i = 0; i<intervals.size(); i++){
            Interval interval1 = intervals.get(i);
            for(int j = i+1; j<intervals.size(); j++){
                Interval interval2 = intervals.get(j);
                if(interval2.start > interval1.start){
                    if(interval1.end <= interval2.start){

                    } else {
                        return false;
                    }
                } else if (interval1.start > interval2.start){
                    if(interval2.end <= interval1.start){

                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
