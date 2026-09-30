class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        } else if(n > 0){
            double sum = 1;
            for(int i = 0; i<n; i++){
                sum = sum*x;
            }
            return sum;
        } else {
            double sum = 1;
            for(int i = 0; i<Math.abs(n); i++){
                sum = sum*x;
            }
            return 1/sum;
        }
    }
}
