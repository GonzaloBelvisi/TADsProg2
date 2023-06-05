package uy.edu.um.prog2.adt.Heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapImplTest {
    @Test
    void insertTest(){
        MyHeap<Double> newHeap = new MyHeapImpl<>(8);
        newHeap.insert(3.0);
        assertEquals(1, newHeap.size());
        newHeap.insert(2.5);
        assertEquals(2, newHeap.size());
        newHeap.insert(5.5);
        assertEquals(3, newHeap.size());
        newHeap.insert(7.7);
        assertEquals(4, newHeap.size());
        newHeap.insert(1.1);
        assertEquals(5, newHeap.size());
    }

    @Test
    void deleteTest() {
        MyHeap<Double> newHeap2 = new MyHeapImpl<>(8);
        newHeap2.insert(3.0);
        newHeap2.insert(2.5);
        newHeap2.insert(5.5);
        newHeap2.insert(7.7);
        newHeap2.insert(1.1);
        assertEquals(5, newHeap2.size());
        try{
            assertEquals(7.7, newHeap2.delete(), 0.0);
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(4, newHeap2.size());
        try{
            assertEquals(5.5, newHeap2.delete(), 0.0);
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(3, newHeap2.size());
        try{
            assertEquals(3.0, newHeap2.delete(), 0.0);
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(2, newHeap2.size());
        try{
            assertEquals(2.5, newHeap2.delete(), 0.0);
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(1, newHeap2.size());
        try{
            assertEquals(1.1, newHeap2.delete(), 0.0);
        }
        catch (EmptyHeapException e){
            System.out.println("OK (heap is empty)");
        }
        assertEquals(0, newHeap2.size());
    }

    @Test
    void sizeTest() {
        MyHeap<Double> newHeap3 = new MyHeapImpl<>(8);
        assertEquals(0, newHeap3.size());
        newHeap3.insert(5.5);
        assertEquals(1, newHeap3.size());
        newHeap3.insert(10.1);
        assertEquals(2, newHeap3.size());
        newHeap3.insert(1.5);
        assertEquals(3, newHeap3.size());
        newHeap3.insert(3.3);
        assertEquals(4, newHeap3.size());
        newHeap3.insert(18.8);
        assertEquals(5, newHeap3.size());
        try{
            newHeap3.delete();
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(4, newHeap3.size());
        try{
            newHeap3.delete();
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(3, newHeap3.size());
        try{
            newHeap3.delete();
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(2, newHeap3.size());
        try{
            newHeap3.delete();
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(1, newHeap3.size());
        try{
            newHeap3.delete();
        }
        catch (EmptyHeapException e){
            System.out.println("Heap is empty");
        }
        assertEquals(0, newHeap3.size());
    }

}