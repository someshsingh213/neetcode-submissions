class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i<tasks.length; i++){
            freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0) + 1);
        }

        int maxFreq = 0;
        int taskTypesWithMaxFreq = 0;
        for(Character key : freqMap.keySet()){
            if(freqMap.get(key) > maxFreq){
                maxFreq = freqMap.get(key);
                taskTypesWithMaxFreq = 1;
            } else if(freqMap.get(key) == maxFreq){
                taskTypesWithMaxFreq++;
            }
        }
        return Math.max(tasks.length, maxFreq + (maxFreq - 1)*n + taskTypesWithMaxFreq - 1);
    }
}
