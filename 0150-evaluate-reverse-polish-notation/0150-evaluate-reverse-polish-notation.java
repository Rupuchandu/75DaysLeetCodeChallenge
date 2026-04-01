import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String tok: tokens) {
            if(tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/")) {
                int b=stack.pop();
                int a=stack.pop();
                int res=0;
                switch(tok) {
                    case "+":
                    res=a+b;
                    break;
                    case "-":
                    res=a-b;
                    break;
                    case "*":
                    res=a*b;
                    break;
                    case "/":
                    res=a/b;
                    break;                  
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tok));
            }
        }
        return stack.pop();
    }
}