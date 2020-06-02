package _09_QueueWithTwoStacks;

import java.util.Stack;

/**
 * @author huwei
 * @date 2020/6/2 23:52
 */
public class QueueWithTwoStacks {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}

class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if( stack1.empty() && stack2.empty() )
            return -1;
        if( !stack2.empty() )
            return stack2.pop();
        while( !stack1.empty() )
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}