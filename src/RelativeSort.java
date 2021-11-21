/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

import java.util.Arrays;

public class RelativeSort {

    /** Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
     * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
     * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
     * Example: Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
     *   Output: [22,28,8,6,17,44]
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSort(int[] arr1, int[] arr2){
        int[] stackSmaller = new int[arr1.length];
        int[] stackBigger = new int[arr1.length];
        int[] output = new int[arr1.length];

        int s=0, b=0, o=0;
        for (int n1 : arr1) {
            if (n1 < arr2[0]) {
                stackSmaller[s] = n1;
                s++;
            } else if (n1 > arr2[0]) {
                stackBigger[b] = n1;
                b++;
            } else {
                output[o] = n1;
                o++;
            }
        }

        //At this point, s is size of stackSmaller, b of stackBigger, o of output
        int last = arr2[0];
        for(int i=1; i<arr2.length; i++){
            if(arr2[i] < last){ //no need for processing stackBigger
                int[] stackSmallerNew = new int[stackSmaller.length];
                int sn=0;
                for(int temp=s-1; temp>=0; temp--){
                    if( stackSmaller[temp] < arr2[i]){
                        stackSmallerNew[sn] = stackSmaller[temp];
                        sn++;
                    }else if( stackSmaller[temp] > arr2[i]){
                        stackBigger[b] = stackSmaller[temp];
                        b++;
                    }else{
                        output[o] = arr2[i];
                        o++;
                    }
                }
                stackSmaller = stackSmallerNew;
                s = sn;
            }else if(arr2[i] > last){ //no need for processing stackSmaller
                int[] stackBiggerNew = new int[stackBigger.length];
                int bn=0;
                for(int temp=b-1; temp>=0; temp--){
                    if( stackBigger[temp] < arr2[i]){
                        stackSmaller[s] = stackBigger[temp];
                        s++;
                    }else if( stackBigger[temp] > arr2[i]){
                        stackBiggerNew[bn] = stackBigger[temp];
                        bn++;
                    }else{
                        output[o] = arr2[i];
                        o++;
                    }
                }
                stackBigger = stackBiggerNew;
                b = bn;
            }else{
                output[o] = arr2[i];
                o++;
            }
            last = arr2[i];
        }
//        System.out.println("stackSmaller: " + Arrays.toString(stackSmaller));
//        System.out.println("stackBigger: " + Arrays.toString(stackBigger));

        //Place the remaining if exists, starting from smallerStack.
        if(s>0){
            while( s>0) {
                int min = stackSmaller[0];
                int[] stackSmallerNew = new int[stackSmaller.length];
                int sn = 0;
                for (int temp = s - 1; temp > 0; temp--) {
                    if (stackSmaller[temp] < min) {
                        stackSmallerNew[sn] = min;
                        sn++;
                        min = stackSmaller[temp];
                    } else {
                        stackSmallerNew[sn] = stackSmaller[temp];
                        sn++;
                    }
                }
                stackSmaller = stackSmallerNew;
                s = sn;
                output[o] = min;
                o++;
            }
        }
        if(b>0){
            while( b>0) {
                int min = stackBigger[0];
                int[] stackBiggerNew = new int[stackBigger.length];
                int bn = 0;
                for (int temp = b - 1; temp > 0; temp--) {
                    if (stackBigger[temp] < min) {
                        stackBiggerNew[bn] = min;
                        bn++;
                        min = stackBigger[temp];
                    } else {
                        stackBiggerNew[bn] = stackBigger[temp];
                        bn++;
                    }
                }
                stackBigger = stackBiggerNew;
                b = bn;
                output[o] = min;
                o++;
            }
        }
        return output;
    }

    public static void main(String[] args){
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        int[] output = relativeSort(arr1, arr2);
        System.out.println("output: " + Arrays.toString(output));

        int[] arr3 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr4 = {2,1,4,3,9,6};
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("arr4: " + Arrays.toString(arr4));
        int[] output2 = relativeSort(arr3, arr4);
        System.out.println("output2: " + Arrays.toString(output2));

        // Runtime: 3 ms, faster than 55.75% of Java online submissions for Relative Sort Array.
        // Memory Usage: 39.5 MB, less than 20.40% of Java online submissions for Relative Sort Array.
    }
}
