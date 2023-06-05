package uy.edu.um.prog2.adt.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListImplTest {
    @Test
    void isEmptyTest(){
        MyLinkedList<Double> list1 = new MyLinkedListImpl<>();
        list1.add(10.5);
        assertFalse(list1.isEmpty());
        list1.remove(0);
        assertTrue(list1.isEmpty());
    }

    @Test
    void containsTest(){
        MyLinkedList<String> list1 = new MyLinkedListImpl<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Cherry");
        list1.add("Date");
        list1.add("Elderberry");
        assertTrue(list1.contains("Banana"));
        assertFalse(list1.contains("Zucchini"));
    }

    @Test
    void addTest(){
        MyLinkedList<String> list1 = new MyLinkedListImpl<>();
        list1.add("Dog");
        list1.add("Cat");
        list1.add("Horse");
        assertEquals(3,list1.getSize());
        assertFalse(list1.isEmpty());
        assertTrue(list1.contains("Dog"));
        assertTrue(list1.contains("Cat"));
        assertTrue(list1.contains("Horse"));
    }

    @Test
    void addFirstTest() {
        MyLinkedList<String> list1 = new MyLinkedListImpl<>();
        list1.add("Dog");
        list1.add("Cat");
        list1.add("Horse");
        list1.addFirst("First");
        assertEquals(4, list1.getSize());
        assertFalse(list1.isEmpty());
        assertTrue(list1.contains("First"));
        assertEquals("First",list1.get(0));
    }

    @Test
    void addLastTest() {
        MyLinkedList<String> list1 = new MyLinkedListImpl<>();
        list1.add("Dog");
        list1.add("Cat");
        list1.add("Horse");
        list1.addLast("Last");
        assertEquals(4, list1.getSize());
        assertFalse(list1.isEmpty());
        assertTrue(list1.contains("Last"));
        assertEquals("Last",list1.get(list1.getSize()-1));
    }

    @Test
    void removeTest(){
        MyLinkedList<String> list1 = new MyLinkedListImpl<>();
        list1.add("Dog");
        list1.add("Cat");
        list1.add("Horse");
        list1.remove(1);
        assertEquals(2,list1.getSize());
        assertFalse(list1.isEmpty());
        assertTrue(list1.contains("Dog"));
        assertFalse(list1.contains("Cat"));
        assertTrue(list1.contains("Horse"));
    }

    @Test
    void getTest(){
        MyLinkedList<String> list1 = new MyLinkedListImpl<>();
        list1.add("Dog");
        list1.add("Cat");
        list1.add("Horse");
        assertEquals("Horse",list1.get(2));
    }


}