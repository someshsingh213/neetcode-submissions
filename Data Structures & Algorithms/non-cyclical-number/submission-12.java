class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = sumOfDigits(n);;
        while(!(sum == 1 || set.contains(sum))){
                set.add(sum);
                sum = sumOfDigits(sum);
        }

        if(sum == 1){
            return true;
        } else {
            return false;
        }
    }

    public int sumOfDigits(int num){
        int sum = 0;
        while(num!=0){
            sum = sum + (num%10)*(num%10);
            num = num/10;
        }
        return sum;
    }
}
