class Solution {
    public int getSum(int a, int b) {
        while(a!=0){
            int carry = (a & b) << 1;
        int sumWithoutCarry = a ^ b;
        a = carry;
        b = sumWithoutCarry;
        }

        return b;
        
    }
}
