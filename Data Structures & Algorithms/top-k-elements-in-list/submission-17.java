class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i =0 ;i <nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length +1];

        for(int i : freq.keySet()){
            if(buckets[freq.get(i)] != null){
                buckets[freq.get(i)].add(i);
            } else {
                buckets[freq.get(i)] = new ArrayList<>(Arrays.asList(i));
            }
        }

        ArrayList<Integer> resList = new ArrayList<>();
        int index = 0;
        for(int i = buckets.length - 1; i>0; i --){
            if(buckets[i]!=null){
                resList.addAll(buckets[i]);
            }
            if(resList.size() == k){
                break;
            }
        }
        
        int [] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
