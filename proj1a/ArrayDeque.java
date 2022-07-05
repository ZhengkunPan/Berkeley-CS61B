public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    /**
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        firstIndex = 4;
        lastIndex = 5;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    @Override
    public void addFirst(T item) {
        incSize();
        items[firstIndex] = item;
        firstIndex = minusOne(firstIndex);
        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    @Override
    public void addLast(T item) {
        incSize();
        items[lastIndex] = item;
        lastIndex = addOne(lastIndex);
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        int ptr = 0;
        while (ptr < size) {
            System.out.print(items[ptr] + " ");
            ptr += 1;
        }
        System.out.println("");
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        firstIndex = addOne(firstIndex);
        T firstItem = items[firstIndex];
        items[firstIndex] = null;
        size -= 1;
        decSize();
        return firstItem;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        lastIndex = minusOne(lastIndex);
        T lastItem = items[lastIndex];
        items[lastIndex] = null;
        size -= 1;
        decSize();
        return lastItem;
    }

    /**
     * Gets the item at the given index.
     */
    @Override
    public T get(int index) {
        return items[(index + firstIndex + 1) % items.length];
    }

    /**
     * Increases array size.
     */
    private void incSize() {
        if (size == items.length) {
            T[] newArr = (T[]) new Object[size * 4];
            if (firstIndex + 1 == lastIndex) {
                System.arraycopy(items, 0,
                        newArr, 0, lastIndex);
                System.arraycopy(items, lastIndex,
                        newArr, newArr.length - size + lastIndex, size - lastIndex);
                firstIndex = newArr.length - size + lastIndex - 1;
            } else {
                System.arraycopy(items, addOne(firstIndex), newArr, addOne(firstIndex), size);
                firstIndex = newArr.length - 1;
                lastIndex = size;
            }
            items = newArr;
        }
    }

    /**
     * Decreases array size
     */
    private void decSize() {
        if (size == 0) {
            items = (T[]) new Object[8];
            size = 0;
            firstIndex = 4;
            lastIndex = 5;
            return;
        }
        if ((float) size / items.length < 0.25) {
            T[] newArr = (T[]) new Object[items.length / 2];
            if (items[0] == null || items[items.length - 1] == null) {
                System.arraycopy(items, addOne(firstIndex), newArr, 0, size);
                lastIndex = size;
                firstIndex = newArr.length - 1;
            } else {
                System.arraycopy(items, 0, newArr, 0, lastIndex);
                System.arraycopy(items, addOne(firstIndex), newArr,
                        newArr.length - items.length + firstIndex + 1,
                        items.length - firstIndex - 1);
                firstIndex = newArr.length - items.length + firstIndex;
            }
            items = newArr;
        }
    }

    /**
     * Minus one on index.
     */
    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return index - 1;
        }
    }

    /**
     * Adds one on index.
     */
    private int addOne(int index) {
        if (index == items.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }
}
