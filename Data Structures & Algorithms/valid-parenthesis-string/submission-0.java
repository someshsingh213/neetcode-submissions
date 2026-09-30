class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> brackets = new Stack();
        Stack<Integer> stars = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') {
                brackets.push(i);
            } else if (ch == '*'){
                stars.push(i);
            } else {
                if(!brackets.isEmpty()){
                    brackets.pop();
                } else if(!stars.isEmpty()){
                    stars.pop();
                } else if (brackets.isEmpty() && stars.isEmpty()){
                    return false;
                }
                
            }
        }

        while(!stars.isEmpty() && !brackets.isEmpty()) {
            if(stars.peek() > brackets.peek()){
                stars.pop();
                brackets.pop();
            } else {
                return false;
            }
        }

        if(stars.isEmpty() && !brackets.isEmpty()){
            return false;
        }

        return true;
    }
}
