package StackAndQueue;

/**
 *
 * linked-list stack
 * Created by qiangzeng on 16/11/28.
 */
public class LinkedStack<T>  {
    Node first = null;

    private int N;


    public boolean isEmpty() {
        return first == null;
    }


    public T pop() {
        if (first == null) {
            return null;
        }
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public int getCount() {
        return N;
    }


    public void push(T item) {

        if (first == null) {
            first = new Node();
            first.item = item;
            return;
        }
        Node oldFirst = first;

        first= new Node();
        first.item = item;
        first.next = oldFirst;

        N++;

    }


    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        do {
            stringBuffer.append(pop() + " ");
        } while (N >= 0);
        return stringBuffer.toString();

    }


    private class Node {
        T item;
        Node next;
    }


    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        String orignal[] = {"h", "l", "l", "o", "e"};

        for (String s : orignal) {
            linkedStack.push(s);
        }

        System.out.println(linkedStack);
    }
}
