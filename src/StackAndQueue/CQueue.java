package StackAndQueue;

import java.util.LinkedList;

public class CQueue {
    LinkedList<Integer> stack0, stack1;

    public CQueue() {
        stack0 = new LinkedList<>();
        stack1 = new LinkedList<>();
    }

    public void appendTail(int val) {
        stack0.push(val);
    }

    public int deleteHead() {
        for (int i = 0; i < stack0.size(); i++) {
            stack1.push(stack0.pop());
        }
        Integer result = stack1.poll();
        return result == null ? -1 : result;
    }
}
