package ProgrammingAssignment2;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * Created by qiangzeng on 16/12/28.
 */
public class Deque<Item> implements Iterable<Item> {
    public Node<Item> first;
    public Node<Item> last;
    public int N;

    public Deque() {

    }


    public boolean isEmpty() {
        return N > 0 ? false : true;
    }


    // is the deque empty?
    public int size() {
        return N;// return the number of items on the deque
    }

    public void addFirst(Item item) { // add the item to the front
        if (first == null) {
            Node<Item> first = new Node<>();
            first.item = item;
            first.next = null;
            this.first = first;
            this.last = first;
        } else {
            Node<Item> temp = this.first;
            Node<Item> newNode = new Node<>();
            newNode.item = item;
            newNode.next = temp;
            temp.parent = newNode;
            this.first = newNode;

        }
        N++;

    }

    public void addLast(Item item) { // add the item to the end
        Node<Item> newLast = new Node<>();
        Node<Item> oldlast = last;

        newLast.item = item;
        newLast.parent = oldlast;
        oldlast.next = newLast;

        this.last = newLast;
        N++;

    }

    public Item removeFirst() { // remove and return the item from the front
        Node<Item> oldFirst = first;
        first = first.next;
        N--;
        return oldFirst.item;

    }


    public Item removeLast() { // remove and return the item from the end
        Item item = last.item;
        Node<Item> temp;
        temp = first;
        while (temp.next != null) {
            temp = temp.next;

        }

        return item;
    }

    private static class Node<Item> {
        Item item;
        Node parent;
        Node next;
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
        strings.addFirst("5");
        strings.addLast("6");
        strings.removeFirst();
        strings.removeFirst();
        strings.addFirst("7");
        for (String string : strings) {

            System.out.println("node:" + string);
        }
        System.out.println(strings.size());


    }

}
