/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.Stack;

public class QueueUsingStacks {

    /**
     * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
     *
     * Implement the MyQueue class:
     *
     * void push(int x) Pushes element x to the back of the queue.
     * int pop() Removes the element from the front of the queue and returns it.
     * int peek() Returns the element at the front of the queue.
     * boolean empty() Returns true if the queue is empty, false otherwise.
     * @param s
     * @return
     */
    static class MyQueue {
        Stack<Integer> stackPush, stackPop;
        Integer peek, peekPush;

        public MyQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
            peek = null;
            peekPush = null;
        }

        public void push(int x) {
            if(stackPop.isEmpty() && stackPush.isEmpty()){
                peek = x;
            }
            if(!stackPop.isEmpty() && stackPush.isEmpty()){
                peekPush = x;
            }
            stackPush.push(x);
        }

        public int pop() {
            if(stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
                int toPop = stackPop.pop();
                if(!stackPop.isEmpty()) {
                    peek = stackPop.peek();
                }else{
                    peek = null;
                }
                return toPop;
            }else{
                int toPop = stackPop.pop();
                if(!stackPop.isEmpty()) {
                    peek = stackPop.peek();
                }else{
                    if(!stackPush.isEmpty()){
                        peek = peekPush;
                    }else{
                        peek = null;
                    }
                }
                return toPop;
            }
        }

        public int peek() {
            return peek;
        }

        public boolean empty() {
            if(stackPush.isEmpty() && stackPop.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
        //Memory Usage: 38.6 MB, less than 12.76% of Java online submissions for Implement Queue using Stacks.
    }
}