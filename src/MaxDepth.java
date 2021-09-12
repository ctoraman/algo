/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class MaxDepth {

    /**
     * Given a valid parentheses string s, return the nesting depth of s.
     * @param s
     * @return
     */
    public static int maxDepth(String s) {
        int countLeft = 0, countRight = 0, count = 0, max = 0;
        for( int i=0; i<s.length(); i++){
            if( s.charAt(i) == '('){
                countLeft++;
                count++;
                if( count > max){
                    max = count;
                }
            }
            if( s.charAt(i) == ')'){
                countRight++;
                count--;
            }
        }
        if( countLeft == countRight){
            return max;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        System.out.println( maxDepth("(1+(2*3)+((8)/4))+1"));
        //Runtime: 1 ms, faster than 44.14% of Java online submissions for Maximum Nesting Depth of the Parentheses.
        //Memory Usage: 39 MB, less than 7.09% of Java online submissions for Maximum Nesting Depth of the Parentheses.
    }
}
