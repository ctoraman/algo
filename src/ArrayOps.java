/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

import java.util.Random;

public class ArrayOps {

    /**
     * Randomize the order of a given array by shuffling.
     * @param arr to be randomized
     */
    public static void randomize(int[] arr){
        Random r = new Random();
        for(int i=arr.length-1; i>1; i--){
            int index = r.nextInt(i);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Initializes an array with the given size,
     *  fills the arrray with integers starting from 1 to n.
     * @param n
     * @return
     */
    public static int[] init(int n){
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }
        return arr;
    }

    /**
     * Returns a string representation for the given array.
     * @param arr
     * @return
     */
    public static String toString(int[] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<arr.length; i++){
            sb.append( arr[i] + ", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Swaps two elements in the given array.
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}