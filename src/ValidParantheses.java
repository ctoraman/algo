/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.Stack;

public class ValidParantheses {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            if(c == ')' || c == '}' || c == ']'){
                if(!stack.isEmpty()) {
                    char left = stack.pop();
                    if ( (c == ')' && left != '(') || (c == '}' && left != '{') || (c == ']' && left != '[')){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"()","()[]{}","(]","([)]","{[]}"};
        for(String s: arr) {
            boolean result = isValid(s);
            System.out.println(s+": "+result);
        }
        //Runtime: 3 ms, faster than 24.05% of Java online submissions for Valid Parentheses.
        //Memory Usage: 38.9 MB, less than 16.03% of Java online submissions for Valid Parentheses.
    }
}