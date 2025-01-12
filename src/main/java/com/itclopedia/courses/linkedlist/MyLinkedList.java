package com.itclopedia.courses.linkedlist;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Inner class representing a node in the linked list.
     */
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    /**
     * Adds an element to the end of the list.
     * @param element the element to add
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes the element at the specified index.
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index) {
        checkIndex(index);
        if (index == 0) {
            T value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return value;
        }

        Node<T> prev = getNode(index - 1);
        T value = prev.next.value;
        prev.next = prev.next.next;
        if (prev.next == null) {
            tail = prev;
        }
        size--;
        return value;
    }



    /**
     * Gets the element at the specified index.
     * @param index the index of the element to get
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * Sets the element at the specified index.
     * @param index the index to set the element at
     * @param element the element to set
     * @return the old element at the index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T set(int index, T element) {
        Node<T> node = getNode(index);
        T oldValue = node.value;
        node.value = element;
        return oldValue;
    }

    /**
     * Returns a sublist from the specified range.
     * @param fromIndex the starting index, inclusive
     * @param toIndex the ending index, exclusive
     * @return a new MyLinkedList containing the elements in the specified range
     * @throws IndexOutOfBoundsException if fromIndex or toIndex is out of range
     */
    public MyLinkedList<T> sublist(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid range");
        }
        MyLinkedList<T> sublist = new MyLinkedList<>();
        Node<T> current = getNode(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(current.value);
            current = current.next;
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

    private Node<T> getNode(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}

