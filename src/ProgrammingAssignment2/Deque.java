package ProgrammingAssignment2;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by qiangzeng on 16/12/24.
 */
public class Deque<Item> implements Iterable<Item> {
    private Item[] array;
    private int last;
    private int first;
    private int N;

    public Deque() { // construct an empty deque
        array = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N > 0 ? false : true;
    }


    // is the deque empty?
    public int size() {
        return N;// return the number of items on the deque
    }

    public void addFirst(Item item) { // add the item to the front
        if (item == null) {
            throw new NullPointerException();
        }
        if (N == array.length) resize(array.length * 2);

        if (N > 0) {
            Item[] temp = (Item[]) new Object[array.length + 1];
            for (int i = 0; i < N; i++) {
                temp[i + 1] = array[(first + i) % array.length];
            }
            temp[first] = item;
            array = temp;
        } else {
            array[first] = item;
        }

        N ++;
        last=N;
    }

    public void addLast(Item item) { // add the item to the end
        if (item == null) {
            throw new NullPointerException();
        }
        if (N == array.length) resize(array.length * 2);
        array[last] = item;
        N++;
        last=N;

    }
    public int getLength(){
        return array.length;
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

    public Item removeFirst() { // remove and return the item from the front
        Item item = array[first];
        if (item == null) {
            throw new NoSuchElementException();
        }
        array[first] = null;
        first++;
        N--;
        subSize();
        return item;

    }

    private void subSize() {
        if (N == array.length / 4) {
            resize(array.length / 2);
        }
    }

    public Item removeLast() { // remove and return the item from the end
        Item item = array[last-1];
        if (item == null) {
            throw new NoSuchElementException();
        }
        array[last-1] = null;
        N--;
        last=N;
        subSize();
        return item;
    }

    public Iterator<Item> iterator() {// return an iterator over items in order from front to end
        return new Iterator<Item>() {
            int i;

            @Override
            public boolean hasNext() {
                return i <N ? true : false;
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

    public static void main(String[] args) { // unit testing
        Deque<Integer> deque = new Deque<>();
        deque.addLast(3);
        deque.addFirst(1);
        deque.removeLast();
        deque.addFirst(0);
        deque.addFirst(11);
        deque.addLast(6);
        deque.addLast(99);
        deque.addLast(8);
        deque.addFirst(10);


        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println("------");

        System.out.println(" deque.removeLast()" + deque.removeLast());
        ;
//        System.out.println(" deque.removeFirst()" + deque.removeFirst()); ;
//        System.out.println(" deque.removeFirst()" + deque.removeFirst()); ;


//        System.out.println(" deque.removeFirst()" + deque.removeFirst());
//        deque.removeFirst();


        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }
        System.out.println("------");
        System.out.println("firstmain:" + deque.first);
        System.out.println("lastmain:" + deque.last);
        System.out.println("array.length:" + deque.getLength());
        System.out.println("deque.size:" + deque.size());
    }
}