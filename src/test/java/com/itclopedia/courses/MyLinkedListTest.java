package com.itclopedia.courses;

import com.itclopedia.courses.linkedlist.MyLinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void testAddAndGet() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test
    void testRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
    }

    @Test
    void testSet() {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.add('A');
        list.add('B');
        assertEquals('B', list.set(1, 'C'));
        assertEquals('C', list.get(1));
    }

    @Test
    void testSublist() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        MyLinkedList<Integer> sublist = list.sublist(1, 3);
        assertEquals(2, sublist.size());
        assertEquals(6, sublist.get(0));
        assertEquals(7, sublist.get(1));
    }

    @Test
    void testSize() {
        MyLinkedList<Boolean> list = new MyLinkedList<>();
        assertEquals(0, list.size());
        list.add(true);
        list.add(false);
        assertEquals(2, list.size());
    }
}
