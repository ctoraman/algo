/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.*;

class RotationalCipher {

    boolean isAlphanumeric(char c){
        if( ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')){
            return true;
        }
        return false;
    }

    int wrapped(char c, int factor){
        if( 'a' <= c && c <= 'z'){
            return 'a' + ((c + factor) - 'a') % ('z'-'a'+1);
        }else if('A' <= c && c <= 'Z'){
            return 'A' + ((c + factor) - 'A') % ('Z'-'A'+1);
        }else if( '0' <= c && c <= '9'){
            return '0' + ((c + factor) - '0') % ('9'-'0'+1);
        }else{
            return c;
        }
    }

    String rotationalCipher(String input, int rotationFactor) {
        String output="";
        //1. iterate each char in the input
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if( !isAlphanumeric(c)){
                output = output + c;
            }else{
                int cInt = (int)c + rotationFactor;
                int w = wrapped(c, rotationFactor);
                output = output + (char)(w);
            }
        }
        return output;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here
        String input_3 = "abcdZXYzxy-999.@";
        int rotationFactor_3 = 0;
        String expected_3 = "abcdZXYzxy-999.@";
        String output_3 = rotationalCipher(input_3, rotationFactor_3);
        check(expected_3, output_3);

        String input_4 = "z";
        int rotationFactor_4 = 1;
        String expected_4 = "a";
        String output_4 = rotationalCipher(input_4, rotationFactor_4);
        check(expected_4, output_4);
    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}