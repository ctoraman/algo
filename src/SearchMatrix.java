/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class SearchMatrix {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int x=0, y=0;
        while(x < m && matrix[x][0] < target){
            x++;
        }
        if(x < m && matrix[x][0] == target){
            return true;
        }
        if(x!=0) {
            x--;
        }
        while(y < n && matrix[x][y] != target){
            y++;
        }
        if(y==n){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean result = searchMatrix(matrix, 13);
        System.out.println(result);
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
        //Memory Usage: 38.5 MB, less than 57.26% of Java online submissions for Search a 2D Matrix.
    }
}

