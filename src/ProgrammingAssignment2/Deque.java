package ProgrammingAssignment2;

import java.util.*;

/**
 * Created by qiangzeng on 16/12/28.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public Deque() {
        Node<Item> first = new Node<>();
        first.item = null;
        first.next = null;
        this.first = first;
        this.last = first;
    }


    public boolean isEmpty() {
        return N <= 0;
    }


    // is the deque empty?
    public int size() {
        return N;// return the number of items on the deque
    }

    public void addFirst(Item item) { // add the item to the front
        if (item == null) {
            throw new NullPointerException();
        }

            Node<Item> temp = this.first;
            Node<Item> newNode = new Node<>();
            newNode.item = item;
            newNode.next = temp;
            temp.parent = newNode;
            this.first = newNode;


        N++;

    }

    public void addLast(Item item) { // add the item to the end
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> newLast = new Node<>();
        Node<Item> oldLast = last;

        newLast.item = item;
        newLast.parent = oldLast;
        oldLast.next = newLast;

        this.last = newLast;
        N++;

    }

    public Item removeFirst() { // remove and return the item from the front
        Node<Item> oldFirst = first;
        Item item = oldFirst.item;
        first = first.next;
         N--;
        oldFirst=null;
        return item;

    }


    public Item removeLast() { // remove and return the item from the end
        Item item = this.last.item;
        if (item == null) {
            throw new NoSuchElementException();
        }
        this.last = this.last.parent;
        this.last.next=null;
         N--;
        return item;
    }

    private static class Node<Item> {
        Item item;
        Node<Item> parent;
        Node<Item> next;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> curent = first;

            @Override
            public boolean hasNext() {
                return curent != null;
            }

            @Override
            public Item next() {
                Item item = curent.item;
                curent = curent.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Deque<String> strings = new Deque<>();
        strings.addFirst("1");
        strings.addFirst("2");
        strings.addFirst("3");
        strings.addFirst("4");
        strings.removeLast();
        strings.addFirst("5");
        strings.addFirst("7");
        strings.addLast("6");

        for (String string : strings) {

            System.out.println("node:" + string);
        }
        System.out.println(strings.size());


    }

}
