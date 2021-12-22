/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.Stack;

public class ReversePolish {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     *
     * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String t: tokens){
            if(t.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(t.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if(t.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(t.equals("/")){
                stack.push((int)((1.0/stack.pop()) * stack.pop()));
            }else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] input = {"4","13","5","/","+"};
        System.out.println(evalRPN(input));
        //Runtime: 4 ms, faster than 92.30% of Java online submissions for Evaluate Reverse Polish Notation.
        //Memory Usage: 38.7 MB, less than 74.97% of Java online submissions for Evaluate Reverse Polish Notation.
    }
}
