import java.util.Arrays;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class ValidWordAbbreviation {

    public static boolean isNumeric(char c){
        if( '0' <= c && c <= '9'){
            return true;
        }
        return false;
    }

    public static boolean validWordAbbreviation(String str, String abb){
        String num="";
        int i=0, j=0;
        while( i<abb.length() && j<str.length()){
            if( isNumeric(abb.charAt(i))){
                num += abb.charAt(i);
                i++;
                continue;
            }
            if( !num.isEmpty()){
                int n = Integer.parseInt(num);
                num="";
                j = j + n;
            }
            if( j < str.length() && str.charAt(j) == abb.charAt(i)) {
                i++;
                j++;
            }else{
                return false;
            }
        }
        if(!num.isEmpty()){
            int n = Integer.parseInt(num);
            j = j + n;
            if( i == abb.length() && j == str.length()){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[][] inputs = {{"internationalization", "i12iz4n"},
                {"internationalization", "i12iz5"},
                {"apple", "a2e"},
                {"apple", "5e"}};
        for(String[] input: inputs){
            boolean result = validWordAbbreviation(input[0], input[1]);
            System.out.println(Arrays.toString(input) + ":\t" + result);
        }
    }

}
