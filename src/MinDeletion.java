import java.util.Arrays;
import java.util.Stack;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class MinDeletion {

    /**
     * A string s is called good if there are no two different characters in s that have the same frequency.
     *
     * Given a string s, return the minimum number of characters you need to delete to make s good.
     *
     * The frequency of a character in a string is the number of times it appears in the string.
     * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
     * @param s
     * @return
     */
    public static int minDeletions(String s) {
        //1. create a hash table for letter counts --O(n)
        int[] counts = new int[26];
        for(int i=0; i<s.length(); i++){
            counts[s.charAt(i)-'a']++;
        }
//        System.out.println("counts: ");
//        int sum=0;
//        for(int i=0; i<counts.length; i++){
//            System.out.print(counts[i]+",");
//            sum += counts[i];
//        }
//        System.out.println("\nsum: "+sum);

        //2. create an array for count freqs --O(k) where k is 26 in this case.
        int[] freqs = new int[(int)Math.pow(10,5)];
        int end=-1;
        for(int i=0; i<counts.length; i++){
            if( counts[i]!=0) {
                freqs[counts[i]]++;
                if(counts[i] > end && freqs[counts[i]] > 1) {
                    end = counts[i];
                }
            }
        }
//        System.out.println("freqs: ");
//        for(int i=0; i<=end; i++){
//            System.out.print(freqs[i]+",");
//        }
//        System.out.println();

        //Runtime: 45 ms, faster than 29.66% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
        //Memory Usage: 88.2 MB, less than 5.23% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
//        //3. make each cell of freqs one --O(k*c*t) where k is the value of end, and c is max freq value, and t is length to find zero cell.
//        int result=0;
//        int temp=-1;
//        for(int i=0; i<=end; i++){
//            if(freqs[i] == 0){
//                temp = i;
//            }else{
//                while(freqs[i] > 1){
//                    result += (i-temp);
//                    freqs[i]--;
//                    if(temp>0) {
//                        freqs[temp] = 1;
//                        do{
//                            temp--;
//                        }while(freqs[temp]!=0);
//                    }
//                }
//            }
//        }

        //3. make each cell of freqs one using two stacks --O(n*c) where max c is  theoretically 10^5/26
        //Runtime: 49 ms, faster than 21.53% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
        //Memory Usage: 39.1 MB, less than 99.80% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
        int result=0;
        Stack<Integer> stackValue = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        for(int i=freqs.length-1; i>0; i--){
            int value = freqs[i];
            if(value > 1){
                for(int j=0; j<value-1; j++) {
                    stackValue.push(1);
                    stackIndex.push(i);
                }
            }else if(value == 0){
                if(!stackValue.isEmpty()){
                    int popValue = stackValue.pop();
                    int popIndex = stackIndex.pop();
                    result += popValue*(popIndex-i);
                }
            }
        }
        while(!stackValue.isEmpty()){
            int popValue = stackValue.pop();
            int popIndex = stackIndex.pop();
            result += popValue*popIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "aab","aaabbbcc","ceabaacb","a","ceabaacbdd",
                "jbddhjemmnhaflahionjoddojoliimdcailihfdleahgbafnknblkheeicoonffenhhmgfhgmnjk",
                "abcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwz",
                "bogoidmdkbllehemdkfofcieckdoffiokflejeeffhihfbbfffboklaoochielobmcekaeoajicke"
        };
        for(String input: inputs) {
            System.out.println("input: " + input);
//            System.out.println("input.length(): " + input.length());
            int result = minDeletions(input);
            System.out.println("result: " + result);
        }
        //Runtime: 45 ms, faster than 29.66% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
        //Memory Usage: 88.2 MB, less than 5.23% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
    }
}