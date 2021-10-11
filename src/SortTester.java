/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class SortTester {
    enum Algo {BUBBLE, SELECTION, INSERTION, COUNTING, QUICK, RADIX, MERGE};

    public static void test(int[] arr, Algo a){
        System.out.println("Before sort: "+ArrayOps.toString(arr));
        long startTime=-1, endTime=-1;
        Sort s;
        if(a == Algo.BUBBLE) {
            s = new BubbleSort();
        }else if(a == Algo.SELECTION) {
           s = new SelectionSort();
        }else if(a == Algo.INSERTION) {
            s = new InsertionSort();
        }else if(a == Algo.COUNTING) {
           s = new CountSort();
        }else if(a == Algo.QUICK) {
            s = new QuickSort();
        }else if(a == Algo.RADIX) {
            s = new RadixSort();
        }else if(a == Algo.MERGE) {
            s = new MergeSort();
        }else{
            s = null;
        }
        startTime = System.nanoTime();
        s.sort(arr);
        endTime = System.nanoTime();
        double duration = (endTime-startTime)/Math.pow(10,6);
        System.out.println("Sorted: " + ArrayOps.toString(arr)+"\n"+
                a.name() + " time (ms): " + duration + "\n");
    }

    public static void main(String[] args) {
        int[] arr = ArrayOps.init(100);
        System.out.println("Init: "+ArrayOps.toString(arr));
        ArrayOps.randomize(arr);
        System.out.println("Randomized: "+ArrayOps.toString(arr)+"\n");

        for(Algo algo: Algo.values()) {
            test(arr.clone(), algo);
        }
    }
}
