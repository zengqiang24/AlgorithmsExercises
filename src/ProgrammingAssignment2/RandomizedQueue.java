package ProgrammingAssignment2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by qiangzeng on 16/12/24.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> last;
    private int n;

    public RandomizedQueue() {

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
        Node<Item> newLast = new Node<>();
        if (last == null) {
            last = new Node<>();
        }
        Node<Item> oldlast = last;

        newLast.item = item;
        newLast.parent = oldlast;
        oldlast.next = newLast;
        this.last = newLast;
        n++;
    }


    public Item dequeue() {// remove and return a random item
        int index = StdRandom.uniform(size());
        System.out.println("index" + index);

        Node<Item> temp = last;
        for (int i = 0; i <= index; i++) {
            Node<Item> curernt = temp;
            if (i == index) {
                Item item = curernt.item;
                Node<Item> parent = curernt.parent;
                Node<Item> next = curernt.next;
                if (parent != null)
                    parent.next = next;
                if (next != null)
                    next.parent = parent;
                if (item == null) throw new NoSuchElementException();
                return item;
            }
            temp = temp.parent;

        }
        return null;

    }


    public Item sample() {// return (but do not remove) a random item
        int index = StdRandom.uniform(size());
        Node<Item> temp = last;
        for (int i = 0; i <= index; i++) {
            Node<Item> curernt = temp;
            if (i == index) {
                Item item = curernt.item;
                if (item == null) throw new NoSuchElementException();
                return item;
            }
            temp = temp.parent;

        }
        return null;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> curent = last;

            @Override
            public boolean hasNext() {
                return curent.parent != null;
            }

            @Override
            public Item next() {
                Item item = curent.item;
                curent = curent.parent;
                if (item == null) {
                    throw new NoSuchElementException();
                }
                return item;
            }
        };
    }


    private static class Node<Item> {
        private Item item;
        private Node<Item> parent;
        private Node<Item> next;
    }
}