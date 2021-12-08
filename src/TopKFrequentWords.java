import java.util.*;
import java.util.Map.Entry;

/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class TopKFrequentWords {

    /**
     * Given an array of strings words and an integer k, return the k most frequent strings.
     *
     * Return the answer sorted by the frequency from highest to lowest.
     *  Sort the words with the same frequency by their lexicographical order.
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        //1. count hash --O(n)
        HashMap<String, Integer> counts = new HashMap<>();
        for(String s: words){
            Integer value = counts.get(s);
            if( value == null) {
                counts.put(s, 1);
            }else{
                counts.put(s, value+1);
            }
        }

        //2. create maxheap or max priority queue --O(klogk)
        PriorityQueue<Entry<String,Integer>> queue = new PriorityQueue<>(
                (x,y) -> (Integer.compare(x.getValue(), y.getValue())==0)?y.getKey().compareTo(x.getKey()):Integer.compare(x.getValue(), y.getValue()));
        Set<Entry<String,Integer>> entries = counts.entrySet();
        for(Entry<String,Integer> e: entries){
            if(queue.size() < k) {
                queue.add(e);
            }else{
                if( (queue.peek().getValue() < e.getValue()) ||
                        (queue.peek().getValue() == e.getValue() && queue.peek().getKey().compareTo(e.getKey()) > 0)){
                    queue.poll();
                    queue.add(e);
                }
            }
        }

        //3. select k elements --O(k)
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Entry<String,Integer> e = queue.poll();
            result.add(0, e.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"i","love","leetcode","i","love","coding"},
                {"the","day","is","sunny","the","the","the","sunny","is","is"},
                {"i","love","leetcode","i","love","coding"},
                {"a","aa","aaa"}
        };
        int[] k = {2,4,3,1};
        for(int i=0; i<input.length; i++){
            List<String> result = topKFrequent(input[i], k[i]);
            System.out.println(result);
        }
        //Runtime: 5 ms, faster than 83.74% of Java online submissions for Top K Frequent Words.
        //Memory Usage: 39.1 MB, less than 85.43% of Java online submissions for Top K Frequent Words.
    }
}