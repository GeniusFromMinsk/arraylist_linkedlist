package com.itclopedia.courses.arraylist;

public class MyArrayList<T> {

    private Object[] elements;
    private int size;

    /**
     * Default constructor initializing the list with a default capacity of 10.
     */
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     * @param element the element to add
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Removes the element at the specified index.
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index) {
        checkIndex(index);
        T oldValue = get(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return oldValue;
    }

    /**
     * Gets the element at the specified index.
     * @param index the index of the element to get
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Sets the element at the specified index.
     * @param index the index to set the element at
     * @param element the element to set
     * @return the old element at the index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T set(int index, T element) {
        checkIndex(index);
        T oldValue = get(index);
        elements[index] = element;
        return oldValue;
    }

    /**
     * Returns a sublist from the specified range.
     * @param fromIndex the starting index, inclusive
     * @param toIndex the ending index, exclusive
     * @return a new MyArrayList containing the elements in the specified range
     * @throws IndexOutOfBoundsException if fromIndex or toIndex is out of range
     */
    public MyArrayList<T> sublist(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid range");
        }
        MyArrayList<T> sublist = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(get(i));
        }
        return sublist;
    }

    /**
     * Returns the number of elements in the list.
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
