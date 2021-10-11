/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class QuickSort extends Sort{

    /**
     * Quick sort algorithm
     * @param arr to be sorted
     * @return sorted arr
     */
    public void sort(int[] arr){
        quickRecursive(arr, 0, 0, arr.length-1, 0,arr.length-1);
    }

    private void quickRecursive(int[] arr, int pivot, int left, int right, int start, int end){
//        System.out.println( ArrayOps.toString(arr) + ", " + left + ", " + right + ", "+ start+", "+end);
        if(left <= end && right >= 0 && start <= end) {
            if (left == right) {
//                System.out.println("quickRecursive("+arr+", "+start+", "+start+", "+(left - 1)+", "+start+","+(left - 1)+");");
                quickRecursive(arr, start, start, left - 1, start,left - 1);
                quickRecursive(arr, left + 1, left + 1, end, left + 1, end);
            }else {
                if (pivot == left) {
                    if (arr[left] > arr[right]) {
                        int temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;
                        left++;
                        pivot = right;
                    } else {
                        right--;
                    }
                } else {
                    if (arr[left] > arr[right]) {
                        int temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;
                        right--;
                        pivot = left;
                    } else {
                        left++;
                    }
                }
                quickRecursive(arr, pivot, left, right, start, end);
            }
        }
    }
}
