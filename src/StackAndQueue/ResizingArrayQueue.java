package StackAndQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by qiangzeng on 16/11/30.
 */
public class ResizingArrayQueue<T> implements Iterable<T> {
    private int N = 0;
    private T arrays[];
    private int first;
    private int last;


    public ResizingArrayQueue() {
        arrays = (T[]) new Object[2];
    }

    public boolean isEmpty(){return N==0;}
    public T dequeue() {
        T item = arrays[first];
        arrays[first] = null;
        first++;
        N--;
        if (N == arrays.length / 4) resize(arrays.length / 2);
        return item;
    }

    public void enqueue(T t) {
        if (N == arrays.length) resize(2 * arrays.length);
        arrays[last++] = t;
        N = last;
    }

    public T peek() {
        return arrays[first];
    }

    public void resize(int length) {
        T temp[] = (T[]) new Object[length];
        for (int i = 0; i < N; i++) {
            temp[i] = arrays[(i + first) % arrays.length];
        }
        arrays = temp;
        first = 0;
        last = N;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i;

            @Override
            public boolean hasNext() {
                return i < last;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T array = arrays[(i + first) % arrays.length];
                i++;
                return array;
            }
        };
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> resizingArrayQueue=new ResizingArrayQueue<>();
        String orignal[] = {"h", "l", "l", "o", "e"};

        for (String s : orignal) {
            resizingArrayQueue.enqueue(s);
        }
        for (String item : resizingArrayQueue) {
            System.out.println(item);
        }
    }
}
