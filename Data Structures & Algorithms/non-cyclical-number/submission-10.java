public class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = sumOfSquares(n);

        while(x!=y){
            x = sumOfSquares(x);
            y = sumOfSquares(y);
            y = sumOfSquares(y);
        }

        return x == 1;
    }

    int sumOfSquares(int n){
        int sum = 0;
        while(n!=0){
            int d = n%10;
            sum = sum + (d*d);
            n = n/10;
        }
        return sum;
    }
}