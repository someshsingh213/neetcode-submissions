class Solution {
    Set<Integer> set = new HashSet<>();
    boolean isNonCyclical = false;


    public boolean isHappy(int n) {
        isCyclical(n);
        return isNonCyclical;
    }

    public void isCyclical(int n) {
        if(set.contains(n)){return;}
        set.add(n);
        if(n == 1){
            isNonCyclical = true;
            return;
        }

        int num = 0;
        while(n!=0){
            num = num + ((n % 10) * (n % 10));
            n = n/10;
        }
        n = num;
        isCyclical(n);
    }
}
