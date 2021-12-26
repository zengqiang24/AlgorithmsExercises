import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by qiangzeng on 16/12/28.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    public Deque() {
        Node<Item> firstItem = new Node<>();
        firstItem.item = null;
        firstItem.next = null;
        this.first = firstItem;
        this.last = firstItem;
    }


    public boolean isEmpty() {
        return n <= 0;
    }


    // is the deque empty?
    public int size() {
        return n;// return the number of items on the deque
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
        n++;

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
        n++;

    }

    public Item removeFirst() { // remove and return the item from the front
        Node<Item> oldFirst = first;
        Item item = oldFirst.item;
        first = first.next;
        n--;
        return item;

    }


    public Item removeLast() { // remove and return the item from the end
        Item item = this.last.item;
        if (item == null) {
            throw new NoSuchElementException();
        }
        this.last = this.last.parent;
        this.last.next = null;
        n--;
        return item;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> parent;
        private Node<Item> next;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> curent = first;

            @Override
            public boolean hasNext() {
                return curent != null;
            }

            @Override
            public Item next() {
                Item item = curent.item;
                curent = curent.next;
                if (item == null) {
                    throw new NoSuchElementException();
                }
                return item;
            }
        };
    }


}
