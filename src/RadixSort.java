import java.util.Arrays;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class RadixSort extends Sort{

    /**
     * Radix sort algorithm
     * @param arr to be sorted
     * @return sorted arr
     */
    public void sort(int[] arr) {
       sortRadix(arr);
    }

    private void sortRadix(int[] arr){
         // 1. find max digit length
        byte max=-1;
        for(int i=0; i<arr.length; i++){
            byte length = getDigitLength(arr[i]);
            if(length>max){
                max=length;
            }
        }
//        System.out.println("max: "+max);

        // 2. save digits of each num in arr
        byte[][] digits = new byte[arr.length][max];
        for (int i = 0; i < arr.length; i++) {
            digits[i] = getDigits(arr[i], max); //returns digits with index 0 is least significant bit.
        }

        // 3. count sort for each digit position
        int[] arrSorted = new int[arr.length];
        byte[][] digitsSorted = new byte[arr.length][max];
        for(int d=0; d<max; d++) {
            // 4. pass arr to count digits
            int[] digitCounts = new int[10];
            for (int i = 0; i < arr.length; i++) {
                digitCounts[ digits[i][d]]++;
            }
            // 5. cumulative sum of digit counts
            for(int i=0; i<digitCounts.length-1; i++){
                digitCounts[i+1] = digitCounts[i] + digitCounts[i+1];
            }

            // 6. re-order numbers in arr according to digit counts
            for( int i=arr.length-1; i>=0; i--){
                int j = --digitCounts[ digits[i][d]];
                arrSorted[j] = arr[i];
                digitsSorted[j] = digits[i];
            }

            for(int i=0; i<arrSorted.length; i++) {
                arr[i] = arrSorted[i];
            }
            for(int i=0; i<digits.length; i++) {
                digits[i] = digitsSorted[i].clone();
            }
        }
    }

    /**
     *
     * @param num
     * @return number of digits in num
     */
    private byte getDigitLength(int num){
        int x=num;
        byte length=0;
        do{
            x = x/10;
            length++;
        }while(x!=0);
        return length;
    }

    /**
     *
     * @param num
     * @return digits in num
     */
    private byte[] getDigits(int num,  byte max){
        byte[] digits = new byte[max];
        int x=num;
        byte i=0;
        do{
            digits[i++] = (byte) (x%10); //234, 0:4, 1:3, 2:2
            x = x/10;
        }while(x!=0);
        return digits;
    }
}
