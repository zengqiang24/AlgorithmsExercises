package StackAndQueue;

import java.util.*;

/**
 * linked-list stack
 * Created by qiangzeng on 16/11/28.
 */
public class ReverseLinkedStack<T> implements IStack<T>, Iterable<T> {
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
            N++;
            return;
        }
        Node oldFirst = first;

        first = new Node();
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

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }


    private class Node {
        T item;
        Node next;
    }

    public <T> T[] reverse(T[] t) {
        int len = N;
        int n = N;
        T[] ts = (T[]) new Object[n];
        while (n > 0) {
            ts[--n] = (T) pop();
        }
        return (T[]) Arrays.copyOf(ts, len, t.getClass());
//        return  ts;
    }

    public static void main(String[] args) {
        ReverseLinkedStack<Integer> linkedStack = new ReverseLinkedStack<>();
        int a[] = {1, 2, 5, 3, 9};


        for (int i : a) {
            linkedStack.push(i);
        }

        System.out.println(linkedStack.getCount());

        Integer[] reverse = linkedStack.reverse(new Integer[10]);

        for (Integer item : reverse) {
            System.out.print(item + "   ");
        }


    }
}
