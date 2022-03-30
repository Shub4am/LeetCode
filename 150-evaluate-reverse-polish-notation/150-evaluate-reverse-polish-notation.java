class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        
        for(String str: tokens){
            if(isOperator(str)){
                
                int i = Integer.parseInt(stack.pop());
                int j = Integer.parseInt(stack.pop());
                int res = 0;
                
                if(str.equals("+")) {
                    res = i + j;
                }else if(str.equals("*")){
                    res = i * j;
                }else if(str.equals("-")){
                    res = j - i;
                }else if(str.equals("/")){
                    res = j / i;
                    
                }
                stack.push(res+"");
            }
            else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.peek());
    }
    private boolean isOperator(String str){
        if(str.equals("+") || str.equals("*") ||str.equals("-") || str.equals("/") )
            return true;
        else
            return false;
    }
}