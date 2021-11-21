import java.util.Arrays;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class DistanceOrder {

    /**
     * You are given four integers row, cols, rCenter, and cCenter.
     *  There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
     *  Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter)
     *  from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.
     *  The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.
     * @param rows
     * @param cols
     * @param rCenter
     * @param cCenter
     * @return
     */
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int totalCells = rows*cols;
        int[][] traversedCells = new int[totalCells][2];
        int traversed = 0;
        traversedCells[traversed++] = new int[]{rCenter, cCenter};
        int i=1;
        while( traversed < totalCells){
            for(int r=0; r<=i; r++){
                for(int c=0; c<=i; c++) {
                    if (r + c == i) {
                        if(rCenter + r < rows && cCenter + c < cols){
                            traversedCells[traversed++] = new int[]{rCenter + r, cCenter + c};
                        }
                        if(rCenter - r < rows && rCenter - r >= 0 && cCenter - c < cols && cCenter - c >= 0){
                            traversedCells[traversed++] = new int[]{rCenter - r, cCenter - c};
                        }
                        if( r != 0 && c != 0) {
                            if (rCenter + r < rows && cCenter - c < cols && cCenter - c >= 0) {
                                traversedCells[traversed++] = new int[]{rCenter + r, cCenter - c};
                            }
                            if (rCenter - r < rows && rCenter - r >= 0 && cCenter + c < cols) {
                                traversedCells[traversed++] = new int[]{rCenter - r, cCenter + c};
                            }
                        }
                    }
                }
            }
            i++;
        }
        return traversedCells;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[][] traversedCells = allCellsDistOrder(5, 6, 2, 2);
        for( int[] cells : traversedCells) {
            System.out.println(Arrays.toString(cells));
        }
        //Runtime: 23 ms, faster than 30.33% of Java online submissions for Matrix Cells in Distance Order.
        //Memory Usage: 86 MB, less than 18.32% of Java online submissions for Matrix Cells in Distance Order.
    }
}
