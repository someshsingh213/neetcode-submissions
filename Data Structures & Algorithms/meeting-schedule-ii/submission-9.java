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
    public int minMeetingRooms(List<Interval> intervals) {
        int [] start = new int [intervals.size()];
        int [] end = new int[intervals.size()];

        
        for(int i = 0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;

        int max = 0;
        int currentCount = 0;

        while(s < intervals.size() && e < intervals.size()){
            if(start[s] < end[e]){
                s++;
                currentCount++;
                max = Math.max(currentCount, max);
            } else {
                e++;
                currentCount--;
                max = Math.max(currentCount, max);
            }
        }

        return max;
    }
}
