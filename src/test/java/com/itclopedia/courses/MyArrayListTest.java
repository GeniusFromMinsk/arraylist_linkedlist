package com.itclopedia.courses;

import com.itclopedia.courses.arraylist.MyArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void testAddAndGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    void testSet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        assertEquals(20, list.set(1, 30));
        assertEquals(30, list.get(1));
    }

    @Test
    void testSublist() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        MyArrayList<Integer> sublist = list.sublist(1, 3);
        assertEquals(2, sublist.size());
        assertEquals(2, sublist.get(0));
        assertEquals(3, sublist.get(1));
    }

    @Test
    void testSize() {
        MyArrayList<Double> list = new MyArrayList<>();
        assertEquals(0, list.size());
        list.add(1.1);
        list.add(2.2);
        assertEquals(2, list.size());
    }
}