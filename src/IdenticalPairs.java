/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class IdenticalPairs {

    /**
     * Given an array of integers nums, return the number of good pairs.
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        // nums = 7 2 1 2 8
        int count = 0;
        for( int i = 0; i<nums.length; i++){
            for( int j = i+1; j<nums.length; j++){
                if( nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1,1,3};
        System.out.println( numIdenticalPairs(nums));
        //Runtime: 1 ms, faster than 71.87% of Java online submissions for Number of Good Pairs.
        //Memory Usage: 38.6 MB, less than 8.49% of Java online submissions for Number of Good Pairs.
    }
}
