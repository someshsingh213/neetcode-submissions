class Solution {
    List<String> list;
    int num;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        num = n;
        generateParanthesisRecursive(n, "", 0); //(3, "")
        return list;
    }

    public void generateParanthesisRecursive(int n, String s, int balance){
        String str1 = s + "("; //"("
        String str2 = s + ")"; //")"

        if(!(str1.length() == 2*n) && (isValidSoFar(str1, balance + 1))){
            generateParanthesisRecursive(n, str1, balance + 1);
        }

        if(str2.length() == (2*n)){
            if(isFinalStringValid(str2, balance - 1, 2*n)){
                list.add(str2);
            } 
        } else {
                if(isValidSoFar(str2, balance - 1)){
                    generateParanthesisRecursive(n, str2, balance-1);
                }
            }
    }

    private boolean isValidSoFar(String str, int balance){
        if(balance >= 0 && balance <= num) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFinalStringValid(String str, int balance, int finalLength) {
            if(balance == 0){
                return true;
            }
        return false;
    }
}
