import java.util.Arrays;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        helper(temperatures, answer, 0, temperatures.length-1);
        return answer;
    }

    public static void helper(int[] temperatures, int[] answer, int start, int end){
        if(start < end) {
            int i = start + 1;
            while (i <= end) {
                if (temperatures[i] > temperatures[start]) {
                    answer[start] = i - start;
                    break;
                }
                i++;
            }
            if(i>end){
                answer[start] = 0;
                i = start+1;
            }
//            System.out.println(Arrays.toString(answer));
//            System.out.println(i);
//            System.out.println(start);
//            System.out.println(end+"\n");
            helper(temperatures, answer, start + 1, i);
            helper(temperatures, answer, i, end);
        }
    }

    public static void main(String[] args) {
//        int[] input = {73,74,75,71,69,72,76,73};
//        int[] input = {30,40,50,60};
        int[] input = {30,60,90};
        int[] answer = dailyTemperatures(input);
        System.out.println(Arrays.toString(answer));
        //Runtime: 1451 ms, faster than 5.01% of Java online submissions for Daily Temperatures.
        //Memory Usage: 51.8 MB, less than 34.55% of Java online submissions for Daily Temperatures.
    }
}
