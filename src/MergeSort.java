/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class MergeSort extends Sort{

    /**
     * Merge sort algorithm
     * @param arr to be sorted
     * @return sorted arr
     */
    public void sort(int[] arr){
       mergeSortRecursive(arr, 0, arr.length-1);
    }

    private void mergeSortRecursive(int[] arr, int start, int end){
        if(start != end) {
//            System.out.println(start + ", "+ end);
            int mid = (end + start) / 2;
            mergeSortRecursive(arr, start, mid);
            mergeSortRecursive(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end){
        int[] arrTemp = new int[end-start+1];
        int i=start, j=mid+1, k=0;
        while(i<=mid && j<=end){
            if( arr[i] <= arr[j]){
                arrTemp[k] = arr[i];
                i++;
            }else{
                arrTemp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            arrTemp[k] = arr[i];
            i++;
            k++;
        }
        while(j<=end){
            arrTemp[k] = arr[j];
            j++;
            k++;
        }
        for(int m=start, n=0; m<=end && n<=arrTemp.length; m++, n++) {
            arr[m] = arrTemp[n];
        }
//        System.out.println(ArrayOps.toString(arrTemp));
//        System.out.println(ArrayOps.toString(arr));
    }
}
