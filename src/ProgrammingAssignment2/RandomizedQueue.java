package ProgrammingAssignment2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by qiangzeng on 16/12/24.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int N;
    private int index;
    private int first;
    private int last;

    public RandomizedQueue() {
        array = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N > 0 ? false : true;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (N == array.length) resize(array.length * 2);
        array[last] = item;
        N++;
        last = N;
    }


    public Item dequeue() {// remove and return a random item
        int index = StdRandom.uniform(size());
        System.out.println("dequeue index " + index);
        if (index == first) {
            Item item = array[first];
            if (item == null) {
                throw new NoSuchElementException();
            }
            array[first] = null;
            first++;
            N--;
            subSize();
            return item;
        } else if (index == last - 1) {
            System.out.println("-----removelast");
            Item item = array[last - 1];
            if (item == null) {
                throw new NoSuchElementException();
            }
            array[last - 1] = null;
            N--;
            last = N;
            subSize();
            return item;
        } else {
            //fisrt index,  index,last ==> temp[]
            Item item = array[index];

            Item[] temp = (Item[]) new Object[array.length - 1];
            for (int i = 0; i < index; i++) {
                temp[i] = array[(i + first) % array.length];
            }
            for (int j = index; j < N - 1; j++) {
                temp[j] = array[(j + 1) % array.length];
            }
            array[index] = null;
            array = temp;
            first = 0;
            N--;
            last = N;
            subSize();
            return item;
        }


    }

    private void subSize() {
        if (N == array.length / 4) {
            resize(array.length / 2);
        }
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            temp[i] = array[(first + i) % array.length];
        }
        array = temp;
        first = 0;
        last = N;
    }

    public Item sample() {// return (but do not remove) a random item

        int index = StdRandom.uniform(first,size());

        Item item = array[index];
        if (item == null) throw new NoSuchElementException();
        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int i;

            @Override
            public boolean hasNext() {
                return i < N ? true : false;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = array[(i + first) % array.length];
                i++;
                return item;
            }
        };
    }

    public static void main(String[] args) {// unit testing
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);

        randomizedQueue.enqueue(3);

        randomizedQueue.enqueue(4);

        for (Integer item : randomizedQueue) {
            System.out.print(" " + item);
        }

        System.out.println("----------");


        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.dequeue():" + randomizedQueue.dequeue());

        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());


        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());
        System.out.println("randomizedQueue.sample():" + randomizedQueue.sample());

    }
}