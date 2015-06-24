import java.util.Stack;

/**
 * Created by chen on 15/5/30.
 * As the title described, you should only use two stacks to implement a queue's actions.
 * The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 * Both pop and top methods should return the value of first element.
 * <p/>
 * Example
 * For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2
 * <p/>
 * Challenge
 * implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.
 */
public class LintCode_40_ImplementAQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /*
    Constructor
     */
    public LintCode_40_ImplementAQueue() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    public int pop() {
        // write your code here
        if (stack1.empty()) {
            stack2Tostack1();
        }
        return stack1.pop();
    }

    public int top() {
        // write your code here
        if (stack1.empty()) {
            stack2Tostack1();
        }
        return stack1.peek();
    }

    private void stack2Tostack1() {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }
}
