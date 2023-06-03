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

}