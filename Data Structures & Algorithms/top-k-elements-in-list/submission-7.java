class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i =0 ;i <nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        List<int []> arr = new ArrayList<>();

        for(int i : freq.keySet()){
            arr.add(new int[] {i, freq.get(i)});
        }

        arr.sort((a,b) -> b[1] - a[1]);

        int [] res = new int[k];

        for(int i = 0; i < k; i++){
            res[i] = arr.get(i)[0];
        }

        return res;
    }
}
