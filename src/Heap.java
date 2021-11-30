/** Max heap implementation.
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.List;
import java.util.ArrayList;

public class Heap <E extends Comparable>{
    private List<E> heap;

    public Heap(){
        heap = new ArrayList<E>();
    }

    public void add(E value){
        if( heap.isEmpty()){
            heap.add(value);
        }else{
            heap.add(value);
            int i=heap.size()-1, parentIndex;
            if (i % 2 == 0) { //if even
                parentIndex = (i/2)-1;
            } else {
                parentIndex = i/2;
            }
            while(i > 0 && heap.get(i).compareTo(heap.get(parentIndex)) > 0){
                swap(i, parentIndex);
                i = parentIndex;
                if (i % 2 == 0) { //if even
                    parentIndex = (i/2)-1;
                } else {
                    parentIndex = i/2;
                }
            }
        }
    }

    private void swap(int i, int parentIndex){
        E temp = heap.get(i);
        heap.set(i, heap.get(parentIndex));
        heap.set(parentIndex, temp);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(heap.get(0)+", ");
        for(int i=0; i<heap.size(); i++){
            if( divideByTwo(i+1)){
                sb.append("\n");
            }
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            if( left<heap.size()){
                sb.append(heap.get(left)+", ");
            }
            if( right<heap.size()){
                sb.append(heap.get(right)+", ");
            }
        }
        return sb.toString();
    }

    private boolean divideByTwo(int i){
        return (i & i-1) == 0;
    }

    public int size(){
        return heap.size();
    }

    public E get(int i){
        return heap.get(i);
    }

    public static void main(String[] args){
        Heap<Integer> heap = new Heap<Integer>();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(9);
        heap.add(2);
        heap.add(4);
        heap.add(12);
        System.out.println(heap);
    }
}