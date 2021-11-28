/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class Hindex {

    /**
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return compute the researcher's h-index.
     *
     * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
     *
     * If there are several possible values for h, the maximum one is taken as the h-index.
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        sort(citations);
        for( int h=citations.length; h>0; h--){
            if( citations[citations.length-h] >= h){
                return h;
            }
        }
        return 0;
    }

    public static void sort(int[] arr){
        mergeSortRecursive(arr, 0, arr.length-1);
    }

    private static void mergeSortRecursive(int[] arr, int start, int end){
        if(start != end) {
//            System.out.println(start + ", "+ end);
            int mid = (end + start) / 2;
            mergeSortRecursive(arr, start, mid);
            mergeSortRecursive(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end){
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
    }

    public static void main(String[] args) {
        int[] nums = {3,0,6,1,5};
        int[] nums2 = {1,3,1};
        int result = hIndex(nums);
        System.out.println(result);
        int result2 = hIndex(nums2);
        System.out.println(result2);
        //Runtime: 1 ms, faster than 49.96% of Java online submissions for H-Index.
        //Memory Usage: 38.5 MB, less than 40.96% of Java online submissions for H-Index.
    }
}
