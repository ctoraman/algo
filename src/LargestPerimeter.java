/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class LargestPerimeter {

    /**
     * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
     *  formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        sort(nums);
        for(int i=nums.length-1; i>=2; i--){
            if( nums[i] < nums[i-1] + nums[i-2]){
                return nums[i] + nums[i-1] + nums[i-2];
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
        int[] nums = {3,6,2,3};
        int result = largestPerimeter(nums);
        System.out.println(result);
        //Runtime: 20 ms, faster than 5.87% of Java online submissions for Largest Perimeter Triangle.
        //Memory Usage: 51.6 MB, less than 28.64% of Java online submissions for Largest Perimeter Triangle.
    }
}
