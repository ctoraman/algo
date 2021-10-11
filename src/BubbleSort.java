/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class BubbleSort extends Sort{

    /**
     * Bubble sort algorithm
     * @param arr to be sorted
     * @return sorted arr
     */
    public void sort(int[] arr){
        for(int i=arr.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if( arr[j] > arr[j+1]){
                    //ArrayOps.swap(arr, j, j+1);
                    int temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}