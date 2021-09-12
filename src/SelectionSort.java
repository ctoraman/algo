/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class SelectionSort {

    /**
     * Selection sort algorithm
     * @param arr to be sorted
     * @return sorted arr
     */
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            //ArrayOps.swap(arr, i, minIndex);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
