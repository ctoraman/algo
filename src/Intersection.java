import java.util.Arrays;

public class Intersection {

    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     *  Each element in the result must be unique and you may return the result in any order.
     *  Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     *  Output: [9,4]
     *  Explanation: [4,9] is also accepted.
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2){
        MergeSort ms = new MergeSort();
        ms.sort(nums1);
        ms.sort(nums2);
        int smallSize = nums1.length;
        if( nums2.length < smallSize){
            smallSize = nums2.length;
        }
        int[] output = new int[smallSize];
        int k=0, lastAdded=-1;
        for(int i=0, j=0; i<nums1.length && j<nums2.length && k<output.length;){
            if(nums1[i] == nums2[j] && lastAdded != nums1[i]){
                output[k] = nums1[i];
                lastAdded = nums1[i];
                k++;
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        if( k>0) {
            int[] output2 = new int[k];
            for (int i = 0; i < output2.length; i++) {
                output2[i] = output[i];
            }
            return output2;
        }else{
            return new int[]{};
        }
    }

    public static void main(String[] args){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println( Arrays.toString(intersection(nums1,nums2)));
        int[] arr3 = {1,2,2,1};
        int[] arr4 = {2,2};
        System.out.println( Arrays.toString(intersection(arr3,arr4)));
        //Runtime: 3 ms, faster than 51.67% of Java online submissions for Intersection of Two Arrays.
        //Memory Usage: 39.3 MB, less than 48.41% of Java online submissions for Intersection of Two Arrays.
    }
}
