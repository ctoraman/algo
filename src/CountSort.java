/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class CountSort extends Sort{

    /**
     * Count sort algorithm
     * @param arr to be sorted
     * @return sorted arr
     */
    public void sort(int[] arr){
        //1. find max
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        //2. count
        int[] counters = new int[max+1]; //assuming that zero is a valid number.
        for(int i=0; i<arr.length; i++){
            counters[arr[i]]++;
        }

        //3. sort
        for(int i=0, j=0; i<counters.length; i++){
            if( counters[i] > 0){
                arr[j] = i;
                j++;
            }
        }
    }
}
