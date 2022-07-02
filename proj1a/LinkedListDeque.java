public class LinkedListDeque<T> {

    private class TNode {
        public T item;
        public TNode next;
        public TNode previous;

        public TNode() {}
        public TNode(T i, TNode p, TNode n) {
            item = i;
            previous = p;
            next = n;
        }

    }
    private TNode sentinel;
    private int size;

    /** Creates an empty LinkedListDeque.*/
    public LinkedListDeque() {
        sentinel = new TNode();
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        sentinel.next.next.previous = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        sentinel.previous = new TNode(item, sentinel.previous, sentinel);
        sentinel.previous.previous.next = sentinel.previous;
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
        int num = 0;
        while (num < size) {
            System.out.print(" " + get(num));
            num += 1;
        }
        System.out.println("");
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst() {
       if (size == 0) {
           return null;
       } else {
           T first = sentinel.next.item;
           sentinel.next = sentinel.next.next;
           sentinel.next.previous = sentinel;
           size -= 1;
           return first;
        }
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T last = sentinel.previous.item;
            sentinel.previous = sentinel.previous.previous;
            sentinel.previous.next = sentinel;
            size -= 1;
            return last;
        }
    }

    /** Gets the item at the given index*/
    public T get(int index) {
        TNode pt = sentinel;
        for (int i = 0; i <= index; i+=1) {
            pt = pt.next;
        }
        return pt.item;
    }

    /** Gets the item at the given index recursively
    public T getRecursive(int index) {
        if (index == 0) {
            return item;
        }

        return next.getRecursive(index-1);
    }
     */
}