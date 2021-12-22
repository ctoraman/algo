/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.Stack;
import java.util.PriorityQueue;

public class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> queue;

    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        queue.add(val);
    }

    public void pop() {
        int popValue = stack.pop();
        queue.remove(popValue);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
        //Runtime: 8 ms, faster than 37.93% of Java online submissions for Min Stack.
        //Memory Usage: 40.2 MB, less than 99.86% of Java online submissions for Min Stack.
    }
}
