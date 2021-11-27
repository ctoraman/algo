import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class PancakeSorting {

    /**
     * Given an array of integers arr, sort the array by performing a series of pancake flips.
     *
     * In one pancake flip we do the following steps:
     *
     * Choose an integer k where 1 <= k <= arr.length.
     * Reverse the sub-array arr[0...k-1] (0-indexed).
     * For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
     *
     * Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
     *
     * @param arr
     * @return
     */
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for(int num=arr.length; num>0; num--){
//            System.out.println("num: "+num);
            //find index
            int index = -1;
            for(int i=0; i<arr.length; i++){
                if(arr[i] == num){
                    index = i;
                }
            }
            if( index == -1){
                return null;
            }
            if( index == arr.length-1){ //already at the end
                continue;
            }
//            System.out.println("index: "+index);
            //flip that value with index to the beginning
            if(index != 0){
                flip(arr, index);
                result.add(index+1);
            }
//            System.out.println("result1: "+result);
//            System.out.println("arr1: "+ Arrays.toString(arr));
            //flip it again to the end
            flip(arr, num-1);
            result.add(num);
//            System.out.println("result2: "+result);
//            System.out.println("arr2: "+ Arrays.toString(arr));
        }
        return result;
    }

    private static void flip(int[] arr, int index){
        for(int i=index; i>index/2; i--){
            int temp = arr[i];
            arr[i] = arr[index-i];
            arr[index-i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4,1};
        List<Integer> result = pancakeSort(nums);
        System.out.println("sorted arr: "+ Arrays.toString(nums));
        System.out.println(result);
        //Runtime: 4 ms, faster than 9.53% of Java online submissions for Pancake Sorting.
        //Memory Usage: 39.7 MB, less than 24.09% of Java online submissions for Pancake Sorting.
    }
}

