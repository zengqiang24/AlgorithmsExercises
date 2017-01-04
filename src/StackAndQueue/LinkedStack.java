package StackAndQueue;

import java.util.Iterator;

/**
 * linked-list stack
 * Created by qiangzeng on 16/11/28.
 */
public class LinkedStack<T> implements IStack<T>,Iterable<T> {
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


    private   class Node {
        T item;
        Node next;
    }


    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        String orignal[] = {"h", "l", "l", "o", "e"};

        for (String s : orignal) {
            linkedStack.push(s);
        }

        for (String item : linkedStack) {
            System.out.println(item);
        }

    }
}
