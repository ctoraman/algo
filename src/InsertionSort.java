/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class InsertionSort {

    /**
     * Insertion sort algorithm
     * @param arr to be sorted
     * @return sorted arr
     */
    public static void insertionSortV1(int[] arr){
        for(int i=1; i<arr.length; i++){
            int j=i-1;
            int k=i;
            while(j >= 0 && arr[k] < arr[j]){
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j--;
                k--;
            }
        }
    }

    public static void insertionSortV2(int[] arr){
        for(int i=1; i<arr.length; i++){
            int j=i-1;
            while(j >= 0 && arr[i] < arr[j]){
                j--;
            }
            int temp = arr[i];
            for(int k=i; k>j+1; k--){
               arr[k] = arr[k-1];
            }
            arr[j+1] = temp;
        }
    }
}
