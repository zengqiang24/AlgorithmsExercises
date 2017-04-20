import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by qiangzeng on 16/12/24.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Object[] array;
    private int n;
    private int first;
    private int last;

    public RandomizedQueue() {
        array = new Object[2];
    }

    public boolean isEmpty() {
        return n <= 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (n == array.length) resize(array.length * 2);
        array[last] = item;
        n++;
        last = n;
    }

    @SuppressWarnings("unchecked")
    private Item get(int index) {
        return (Item) array[index];
    }

    @SuppressWarnings("unchecked")
    public Item dequeue() {// remove and return a random item
        int index = StdRandom.uniform(size());
        if (index == first) {
            Item item = get(first);
            if (item == null) {
                throw new NoSuchElementException();
            }
            array[first] = null;
            first++;
            n--;
            subSize();
            return item;
        } else if (index == last - 1) {
            Item item = get(last - 1);
            if (item == null) {
                throw new NoSuchElementException();
            }
            array[last - 1] = null;
            n--;
            last = n;
            subSize();
            return item;
        } else {
            //fisrt index,  index,last ==> temp[]
            Item item = get(index);
            Item[] temp = (Item[]) new Object[array.length - 1];
            for (int i = 0; i < index; i++) {
                temp[i] = (Item) array[(i + first) % array.length];
            }
            for (int j = index; j < n - 1; j++) {
                temp[j] = (Item) array[(j + 1) % array.length];
            }
            array[index] = null;
            array = temp;
            first = 0;
            n--;
            last = n;
            subSize();
            return item;
        }


    }

    private void subSize() {
        if (n == array.length / 4) {
            resize(array.length / 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < n; i++) {
            temp[i] = (Item) array[(first + i) % array.length];
        }
        array = temp;
        first = 0;
        last = n;
    }

    public Item sample() {// return (but do not remove) a random item

        int index = StdRandom.uniform(first, size());

        Item item = get(index);
        if (item == null) throw new NoSuchElementException();
        return item;
    }

    @SuppressWarnings("unchecked")
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int i;

            @Override
            public boolean hasNext() {
                return i < n;
            }

            @Override
            public Item next() {
                Item item = (Item) array[(i + first) % array.length];
                i++;
                if (item == null) {
                    throw new NoSuchElementException();
                }
                return item;
            }
        };
    }

}