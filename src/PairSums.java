/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.io.*;
import java.util.*;


class PairSums {

    int numberOfWays(int[] arr, int k) {
        int output=0;
        if( arr.length == 1){
            return output;
        }

        // 1. add elements into hashmap --O(n)
        Map<Integer, Integer> counts = new HashMap<>();
        for(int element: arr){
            if(counts.containsKey(element)){
                counts.put(element, counts.get(element)+1);
            }else{
                counts.put(element, 1);
            }
        }

        // 2. check each element to make a pair with hashmap --O(n)
        for(int element: arr){
            if(element < k && counts.containsKey(k-element)){
                if( element == k-element){
                    output += (counts.get(k-element)-1);
                }else{
                    output += counts.get(k-element);
                }
            }
        }

        return output/2;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

    }
    public static void main(String[] args) {
        new PairSums().run();
    }
}