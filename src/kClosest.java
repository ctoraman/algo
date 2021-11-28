import java.util.Arrays;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class kClosest {

    /**
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
     *
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     *
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     * @param points
     * @param k
     * @return
     */
    public static int[][] kClosest(int[][] points, int k) {
        int[] distances = new int[points.length];
        for(int r=0; r<points.length; r++){
            int[] row = points[r];
            distances[r] = row[0]*row[0] + row[1]*row[1];
        }
        int[][] result = new int[k][2];
        int count = 0;
        while(count < k) {
            result[count++] = points[findMinIndex(distances)];
        }
        return result;
    }

    private static int findMinIndex(int[] distances){
        int min=distances[0], minIndex=0;
        while(distances[minIndex] == -1) {
            minIndex++;
            min = distances[minIndex];
        }
        for(int i=minIndex+1; i<distances.length; i++){
            if( distances[i] < min && distances[i] >= 0){
                min = distances[i];
                minIndex = i;
            }
        }
        distances[minIndex] = -1;
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3},{-2,2}};
        int[][] result = kClosest(nums, 1);
        for(int[] r: result) {
            System.out.println(Arrays.toString(r));
        }
        int[][] nums2 = {{3,3},{5,-1},{-2,4}};
        int[][] result2 = kClosest(nums2, 2);
        for(int[] r: result2) {
            System.out.println(Arrays.toString(r));
        }
        //Runtime: 1129 ms, faster than 5.11% of Java online submissions for K Closest Points to Origin.
        //Memory Usage: 48.4 MB, less than 40.22% of Java online submissions for K Closest Points to Origin.
    }
}
