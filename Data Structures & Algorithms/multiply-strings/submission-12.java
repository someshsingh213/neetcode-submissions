class Solution {
    public String multiply(String num1, String num2) {
        int [] result = new int [num1.length() + num2.length()];
        for(int i = num1.length() - 1; i>=0; i--){
            for(int j = num2.length() - 1; j>=0; j--){
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';

                int p = n1 * n2;
                int index = (i+j)+1;
                result[index] = result[index] + p;
                int temp = result[index];
                result[index] = result[index]%10;
                result[index-1] = result[index-1] + temp/10;
            }
        }
        
        String res = "";
        int start = result.length;
        for(int i = 0; i<result.length; i++){
            if(result[i] == 0) {
            } else {
                start = i;
                break;
            }
        }

        for(int i = start; i<result.length; i++){
            res = res + result[i];
        }

        return res.length() == 0 ? "0" : res;
    }
}
