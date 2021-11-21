/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

import java.util.Arrays;

public class SortByParity {

    public static int[] sortArrayByParityII(int[] nums) {
        int[] oddStack = new int[nums.length];
        int[] evenStack = new int[nums.length];
        for(int i=0; i<oddStack.length; i++){
            oddStack[i] = -1;
            evenStack[i] = -1;
        }
        int e=0, o=0;
        for(int i=0; i<nums.length; i++){
            if( nums[i]%2 == 0 && i%2 != 0){
                evenStack[e++] = i;
            }else if( nums[i]%2 != 0 && i%2 == 0){
                oddStack[o++] = i;
            }
        }
        for(int i=e-1, j=o-1; i>=0 && j>=0; i--, j--){
            int temp = nums[evenStack[i]];
            nums[evenStack[i]] = nums[oddStack[j]];
            nums[oddStack[j]] = temp;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {4,2,5,7};
        System.out.println( Arrays.toString(sortArrayByParityII(nums)));
        //Runtime: 7 ms, faster than 13.03% of Java online submissions for Sort Array By Parity II.
        //Memory Usage: 53.1 MB, less than 5.84% of Java online submissions for Sort Array By Parity II.
    }
}
