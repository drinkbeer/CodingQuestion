import java.util.Stack;

/**
 * Created by chen on 15/5/30.
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * It should support push, pop and min operation all in O(1) cost.
 * <p/>
 * Example
 * Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1
 * <p/>
 * Note
 * min operation will never be called if there is no number in the stack
 */
public class LintCode_12_MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public LintCode_12_MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);

        if (min.empty()) {
            min.push(number);
        } else {
            int top = min.peek();
            min.push(Math.min(top, number));
        }
    }

    public int pop() {
        // write your code here
        if (stack.empty()) {
        }

        min.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
