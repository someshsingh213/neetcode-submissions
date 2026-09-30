class Solution {

    public int climbStairs(int n) {
        int x = 1;
        int y = 2;

for(int i = 3; i<=n; i++){
    int temp = y;
    y = x + y;
    x = temp;
}

if(n==1){
    return 1;
}

        return y;
    }
}