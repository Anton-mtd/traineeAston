package mylist;

import mylist.MyList;

import java.util.Arrays;
import java.util.Objects;

/**
 * mylist.MyArrayList is class for keep any Comparable Objects and works with them.
 * Comparable is requirement for method's work sort()
 *
 * @param <E> is any class with implementation Comparable
 * @author Anton Skomorokhin
 */
public class MyArrayList<E extends Comparable> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private Object[] elementData = {};
    private int size;

    /**
     * initialise empty MyArraylist
     */
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;

    }

    /**
     * Initialise MyArraylist with adding elements from an array that is used as a parameter
     * @param elementData is Object's array for integrate into mylist.MyArrayList
     */
    public MyArrayList(Object[] elementData) {
        size = elementData.length;
        this.elementData = elementData;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = Math.max((minCapacity - oldCapacity), oldCapacity >> 1) + oldCapacity;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }


    /**
     *
     * @return current size. Quantity elements in mylist.MyArrayList
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *  Add a new element in mylist.MyArrayList and return a boolean as result complete operation
     */
    @Override
    public boolean add(E e) {
        add(e, elementData, size);
        return true;
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    /**
     *  Delete an element in mylist.MyArrayList and return a boolean as result complete operation
     *  @param o is Object that will be deleted
     */
    @Override
    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    /**
     *  Delete an element with it's index in mylist.MyArrayList and return a boolean as result complete operation
     *  @param index is Object's index that will be deleted
     */
    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        fastRemove(es, index);
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    /**
     * @return true or false depends on has or not elements in the mylist.MyArrayList
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     *
     * @param e is Object that can be existed in mylist.MyArrayList
     * @return true or false depends on has or not 'e' in mylist.MyArrayList
     */
    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    /**
     *
     * @param o is Object whose index will be got
     * @return Object's index as a integer value
     */
    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    /**
     *
     * @param index is Object's index whose will be got
     * @return Object by it's index
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    private int indexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param index is index whose object will be set
     * @param e set a new Object's value
     * @return a new Object's value
     */
    @Override
    public E set(int index, E e) {
        elementData[index] = e;
        return (E) elementData[index];
    }

    /**
     * transform mylist.MyArrayList to Object[]
     */
    @Override
    public Object[] toArray() {
        trimToSize();
        return elementData;
    }

    /**
     * sort elements in mylist.MyArrayList from less to biggest
     */
    @Override
    public void sort() {
         this.elementData = QuickSort.sort(this).toArray();
    }


    private void trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0)
                    ? DEFAULTCAPACITY_EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && Arrays.equals(elementData, that.elementData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elementData);
        return result;
    }
}
