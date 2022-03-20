/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class MaxCumulativeObservable {

    public static int findMaximumSum(int[] stockPrice, int k){
        int max=-1;
        for(int i=0; i<=stockPrice.length-k; i++){
            int sum = distinct(stockPrice, i, k);
            if( sum != -1 && sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static int distinct(int[] stockPrice, int startIndex, int k){
        int sum=0;
        for(int i=startIndex; i<startIndex+k; i++){
            for(int j=i+1; j<startIndex+k; j++) {
                if (stockPrice[i] == stockPrice[j]) {
                    return -1;
                }
            }
            sum=sum+stockPrice[i];
        }
        return sum;
    }

    public static void main(String[] args){
//      int[] stockPrice = {1,2,7,7,4,3,6};
//      int[] stockPrice = {1,2,3,7,3,5};
        int[] stockPrice = {1,2,4,4};
        int k=4;
        int result = findMaximumSum(stockPrice, k);
        System.out.println(result);
    }
}
