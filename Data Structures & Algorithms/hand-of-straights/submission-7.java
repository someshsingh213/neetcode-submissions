class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>(); //number, numberOfTimes
        
        for(int i = 0; i<hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : map.keySet()){
            minHeap.offer(i);
        }

        int num;
        while(!minHeap.isEmpty()){
            num = minHeap.peek();
            if(map.get(num) <= 0 ){
                minHeap.poll();
                continue;
            }
            for(int i = num; i<num+groupSize; i++){
                if(map.containsKey(i) && map.get(i) > 0){
                    map.put(i, map.get(i)-1);
                } else {
                    return false;
                }
            }
            
        }

        return true;
        
    }
}
