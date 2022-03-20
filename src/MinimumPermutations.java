/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.*;

class MinimumPermutations {

    List<int[]> generatePermutations(int[] current){
        List<int[]> permutations = new ArrayList<>();

        for(int i=0; i<current.length; i++){
            for(int j=i+1; j<current.length; j++){
                int[] clone = current.clone();
                reverse(clone, i, j);
                permutations.add(clone);
            }
        }
        return permutations;
    }

    void reverse(int[] clone, int i, int j){
        for( int x=i, y=j; x<y; x++, y--){
            int temp = clone[x];
            clone[x] = clone[y];
            clone[y] = temp;
        }
    }

    boolean isSame(int[] arr1, int[] arr2){
        for(int i=0; i<arr1.length; i++){
            if( i>= arr2.length || arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    int minOperations(int[] arr) {
        int numOps = 0;

        //0. create the solution
        int[] solution = arr.clone();
        Arrays.sort(solution);

        Queue<int[]> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(arr);

        while( !queue.isEmpty()){
            //1. generate permutations by reversing
            int[] current = queue.remove();
            List<int[]> permutations = generatePermutations(current);

            //2. check if solution is found, then add them to queue
            for(int[] p: permutations){
                if( isSame(p, solution)){
                    return numOps+1;
                }
                if( !seen.contains(Arrays.toString(p))){
                    seen.add( Arrays.toString(p));
                    queue.add(p);
                }
            }
            numOps++;
        }
        return numOps;
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

        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        int output_1 = minOperations(arr_1);
        check(expected_1, output_1);

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        int output_2 = minOperations(arr_2);
        check(expected_2, output_2);

    }
    public static void main(String[] args) {
        new MinimumPermutations().run();
    }
}