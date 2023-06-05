package uy.edu.um.prog2.adt.Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueImplTest {
    @Test
    void isEmptyTest() throws EmptyQueueException {
        MyQueue<Integer> queue1 = new MyQueueImpl<>();
        queue1.enqueue(1);
        assertFalse(queue1.isEmpty());
        queue1.dequeue();
        assertTrue(queue1.isEmpty());

        try{
            queue1.dequeue();
        }catch (EmptyQueueException e){
            System.out.println("OK");
        }
    }

    @Test
    void enqueueTest() throws EmptyQueueException {
        MyQueue<Integer> queue1 = new MyQueueImpl<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        queue1.enqueue(40);
        queue1.enqueue(50);
        assertEquals(5, queue1.getSize());
        assertFalse(queue1.isEmpty());
        assertEquals(10, queue1.dequeue());
        assertEquals(20, queue1.dequeue());
        assertEquals(30, queue1.getFirstElement());
    }

    @Test
    void dequeueTest() throws EmptyQueueException {
        MyQueue<Integer> queue1 = new MyQueueImpl<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        queue1.enqueue(40);
        queue1.enqueue(50);
        assertEquals(10, queue1.getFirstElement());
        assertEquals(10, queue1.dequeue());
        assertEquals(20, queue1.getFirstElement());
        assertEquals(20, queue1.dequeue());
        assertEquals(30, queue1.getFirstElement());
        assertEquals(30, queue1.dequeue());
        assertEquals(40, queue1.getFirstElement());
        assertEquals(40, queue1.dequeue());
        assertEquals(50, queue1.getFirstElement());
        assertEquals(50, queue1.dequeue());
        assertTrue(queue1.isEmpty());

        try{
            queue1.dequeue();
        }catch (EmptyQueueException e){
            System.out.println("OK");
        }
    }

    @Test
    void getFirstElementTest() throws EmptyQueueException {
        MyQueue<Integer> queue1 = new MyQueueImpl<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        queue1.enqueue(40);
        queue1.enqueue(50);
        assertEquals(10, queue1.dequeue());
        assertEquals(20, queue1.dequeue());
        assertEquals(30, queue1.dequeue());
        assertEquals(40, queue1.dequeue());
        assertEquals(50, queue1.dequeue());
    }

    @Test
    void sizeTest() throws EmptyQueueException {
        MyQueue<Integer> queue1 = new MyQueueImpl<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        queue1.enqueue(40);
        queue1.enqueue(50);
        assertEquals(5, queue1.getSize());
        assertEquals(10, queue1.dequeue());
        assertEquals(4, queue1.getSize());
    }

    @Test
    void getFirstLastTest(){
        MyQueue<Integer> queue1 = new MyQueueImpl<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        queue1.enqueue(40);
        queue1.enqueue(50);
        assertEquals(50, queue1.getLast());
        assertEquals(10, queue1.getFirst());
    }

    @Test
    void containsTest(){
        MyQueue<Integer> queue1 = new MyQueueImpl<>();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);

        assertTrue(queue1.contain(10));
        assertTrue(queue1.contain(20));
        assertTrue(queue1.contain(30));
        assertFalse(queue1.contain(100));
    }

}