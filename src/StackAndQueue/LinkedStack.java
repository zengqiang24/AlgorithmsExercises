package StackAndQueue;

/**
 * Created by qiangzeng on 16/11/28.
 */
public class LinkedStack implements MyStack<String> {
    Node first = null;

    private int N;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String pop() {
        if (first == null) {
            return null;
        }
        String item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public int getCount() {
        return N;
    }

    @Override
    public void push(String item) {

        if (first == null) {
            first = new Node();
            first.item = item;
            return;
        }
        Node oldFirst = first;

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = oldFirst;

        first = newNode;

        N++;

    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        do {
            stringBuffer.append(pop() + " ");
        } while (N >= 0);
        return stringBuffer.toString();

    }


    private class Node {
        String item;
        Node next;
    }


    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        String orignal[] = {"h", "l", "l", "o", "e"};

        for (String s : orignal) {
            linkedStack.push(s);
        }

        System.out.println(linkedStack);
    }
}
