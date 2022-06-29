public class ArrayDeque<T> {

    private class TNode {
        public T item;
        public T next;
        public T previous;

        public TNode() {
            next = null;
            previous = null;
        }
        public TNode(T i, T p, T n) {
            item = i;
            previous = p;
            next = n;
        }
    }
    private int size;
    private T[] items;
    private int prevIndex;
    private int nextIndex;
    private TNode sentinel;

    /** Creates an empty array deque.*/
    public ArrayDeque() {
        items = (T[]) new Object[8];
        prevIndex =  items.length-1;
        nextIndex = 0;
        sentinel.previous = items[items.length-1];
        sentinel.next = items[0];
        size = 0;
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        size += 1;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque() {
        for (int i = 0; i < items.length; i += 1) {
            System.out.print(" " + items[i]);
        }
        System.out.println("");
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst() {
        size -= 1;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast() {
        size -= 1;
    }

    /** Gets the item at the given index*/
    public T get(int index) {
        return items[index];
    }
}
