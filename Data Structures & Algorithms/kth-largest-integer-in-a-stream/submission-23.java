class KthLargest {
    List<Integer> list = new ArrayList<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(int i = 0; i<nums.length; i++){
            list.add(nums[i]);
        }
        this.k = k;
    }
    
    public int add(int val) {
        list.add(val);
        list.sort(Collections.reverseOrder());
        return list.get(k-1);
    }
}
