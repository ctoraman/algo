import java.util.Arrays;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class Anagram {

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if( s.length() != t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] sIntArr = new int[sArr.length];
        for(int i=0; i<sIntArr.length; i++){
            sIntArr[i] = sArr[i];
        }
        int[] tIntArr = new int[sArr.length];
        for(int i=0; i<tIntArr.length; i++){
            tIntArr[i] = tArr[i];
        }
        sort(sIntArr);
        sort(tIntArr);
        for(int i=0, j=0; i<sIntArr.length && j<tIntArr.length; i++,j++){
            if( sIntArr[i] != tIntArr[j]){
                return false;
            }
        }
        return true;
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
        String s = "anagram", t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println(result);
        //Runtime: 16 ms, faster than 16.16% of Java online submissions for Valid Anagram.
        //Memory Usage: 41 MB, less than 14.82% of Java online submissions for Valid Anagram.
    }
}
