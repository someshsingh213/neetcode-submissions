class Solution {
    public int[] plusOne(int[] digits) {
        long num = 0;
        int areAllDigitsNine = 0;
        for(int i = 0; i < digits.length; i++){
num = num + (long)(digits[i] * Math.pow(10, digits.length - i - 1));            if(digits[i] == 9){
                areAllDigitsNine++;
            }
        }
        num = num + 1;


int len = 0;
        if(areAllDigitsNine == digits.length){
len = digits.length + 1;
        } else {
            len = digits.length;
        }
        int [] digits2 = new int[len];
        len --;
        while(num != 0 && len >= 0){
int d = (int)(num % 10); // FIXED: parentheses ensure the modulus happens before cast


            digits2[len] = d;
            len --;
            num = num / 10;
        }

        return digits2;
    }
}
