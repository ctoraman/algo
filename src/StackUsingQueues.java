/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.Queue;
import java.util.LinkedList;

public class StackUsingQueues {

    /**
     * Implement a last-in-first-out (LIFO) stack using only two queues.
     * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
     */
    static class MyStack {
        Queue<Integer> q1, q2;

        public MyStack() {
            q1 = new LinkedList();
            q2 = new LinkedList();
        }

        public void push(int x) {
            if(q1.isEmpty()){
                q1.add(x);
            }else{
                q2.add(q1.remove());
                q1.add(x);
            }
        }

        public int pop() {
            if(!q1.isEmpty()){
                return q1.remove();
            }else{
                int size = q2.size();
                for(int i=0; i<size-2; i++){
                    q2.add(q2.remove());
                }
                if(size>1) {
                    q1.add(q2.remove());
                }
                return q2.remove();
            }
        }

        public int top() {
            if(!q1.isEmpty()){
                return q1.peek();
            }else{
                int peek=-1;
                int size = q2.size();
                for(int i=0; i<size; i++){
                    peek = q2.remove();
                    q2.add(peek);
                }
                return peek;
            }
        }

        public boolean empty() {
            if(q1.isEmpty() && q2.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
        //Memory Usage: 36.9 MB, less than 61.89% of Java online submissions for Implement Stack using Queues.
    }
}