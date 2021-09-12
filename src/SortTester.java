/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class SortTester {
    enum Algo {BUBBLE, SELECTION, INSERTIONv1, INSERTIONv2, COUNTING};

    public static void test(int[] arr, Algo a){
        System.out.println("Before sort: "+ArrayOps.toString(arr));
        long startTime=-1, endTime=-1;
        if(a == Algo.BUBBLE) {
            startTime = System.nanoTime();
            BubbleSort.bubbleSort(arr);
            endTime = System.nanoTime();
        }else if(a == Algo.SELECTION) {
            startTime = System.nanoTime();
            SelectionSort.selectionSort(arr);
            endTime = System.nanoTime();
        }else if(a == Algo.INSERTIONv1) {
            startTime = System.nanoTime();
            InsertionSort.insertionSortV1(arr);
            endTime = System.nanoTime();
        }else if(a == Algo.INSERTIONv2) {
            startTime = System.nanoTime();
            InsertionSort.insertionSortV2(arr);
            endTime = System.nanoTime();
        }else if(a == Algo.COUNTING) {
            startTime = System.nanoTime();
            CountSort.countSort(arr);
            endTime = System.nanoTime();
        }
        double duration = (endTime-startTime)/Math.pow(10,6);
        System.out.println("Sorted: " + ArrayOps.toString(arr)+"\n"+
                a.name() + " time (ms): " + duration + "\n");
    }

    public static void main(String[] args) {
        int[] arr = ArrayOps.init(100);
        System.out.println("Init: "+ArrayOps.toString(arr));
        ArrayOps.randomize(arr);
        System.out.println("Randomized: "+ArrayOps.toString(arr)+"\n");

        test(arr.clone(), Algo.BUBBLE);
        test(arr.clone(), Algo.SELECTION);
        test(arr.clone(), Algo.INSERTIONv1);
        test(arr.clone(), Algo.INSERTIONv2);
        test(arr.clone(), Algo.COUNTING);
    }
}
