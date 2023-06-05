package uy.edu.um.prog2.adt.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackImplTest {

    @Test
    void isEmptyTest() throws EmptyStackException{
        MyStackImpl<String> newStack = new MyStackImpl<String>();
        newStack.push("A");
        newStack.pop();
        assertTrue(newStack.isEmpty());
        newStack.push("A");
        assertFalse(newStack.isEmpty());
    }

    @Test
    void pushTest() throws EmptyStackException {
        MyStackImpl<String> newStack = new MyStackImpl<String>();
        newStack.push("B");
        assertFalse(newStack.isEmpty());
        assertEquals(1, newStack.getSize());
        assertEquals("B", newStack.top());
    }

    @Test
    void popTest() throws EmptyStackException {
        MyStackImpl<String> newStack = new MyStackImpl<String>();
        newStack.push("C");
        newStack.push("D");
        assertEquals("D", newStack.pop());
        assertEquals(1, newStack.getSize());
        assertEquals("C", newStack.top());
    }

    @Test
    void topTest() throws EmptyStackException {
        MyStackImpl<String> newStack = new MyStackImpl<String>();
        newStack.push("E");
        assertEquals("E", newStack.top());
        newStack.push("F");
        assertEquals("F", newStack.top());
    }

    @Test
    void makeEmptyTest() throws EmptyStackException {
        MyStackImpl<String> newStack = new MyStackImpl<String>();
        newStack.push("G");
        newStack.push("H");
        newStack.makeEmpty();
        assertTrue(newStack.isEmpty());
        assertEquals(0, newStack.getSize());
    }

    @Test
    void containTest() throws EmptyStackException {
        MyStackImpl<String> newStack = new MyStackImpl<String>();
        newStack.push("I");
        newStack.push("J");
        assertTrue(newStack.contain("I"));
        assertFalse(newStack.contain("K"));
    }

}