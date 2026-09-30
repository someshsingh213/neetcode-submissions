class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i<tokens.length; i++){
            String s = tokens[i];
            if(s.equals("*") || s.equals("+") || s.equals("-") || s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int c;
                if(s.equals("*")){
                    c = a * b;
                } else if(s.equals("/")){
                    c = a / b;
                } else if(s.equals("-")){
                    c = a - b;
                } else {
                    c = a + b;
                }
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
