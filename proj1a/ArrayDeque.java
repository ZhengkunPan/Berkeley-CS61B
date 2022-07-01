public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int prevIndex;
    private int nextIndex;

    /** Creates an empty array deque.*/
    public ArrayDeque() {
        items = (T[]) new Object[8];
        prevIndex = 0;
        nextIndex = 1;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        items[prevIndex] = item;
        prevIndex -= 1;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        items[nextIndex] = item;
        nextIndex += 1;
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
        items[prevIndex+1] = null;
        prevIndex += 1;
        size -= 1;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast() {
        items[nextIndex-1] = null;
        nextIndex -= 1;
        size -= 1;
    }

    /** Gets the item at the given index.*/
    public T get(int index) {
        return items[index];
    }

    /** Calculates the index*/
    public int calcIndex(int index) {
        if (index < 0) {
            return  items.length - 1;
        }

        if (index >= items.length) {
            return 0;
        }

        return index;
    }

    /** Determines if array needs to be resized*/
    public boolean deterResize() {
        return (float) size / items.length >= 0.25;
    }

    /** Resizes the array.*/
    public void resize(int capacity) {
        T[] newArr = (T[]) new Object[size*4];

    }

}
