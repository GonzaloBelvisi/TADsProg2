package uy.edu.um.prog2.adt.Hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClosedHashImplTest {

    @Test
    void putTest(){
        MyHash<Integer, Integer > newHash = new MyClosedHashImpl<>();
        assertEquals(0, newHash.size());
        assertTrue(newHash.isEmpty());
        newHash.put(10002, 10002);
        newHash.put(10003, 10003);
        assertEquals(2, newHash.size());
        newHash.put(30003, 30003);
        assertEquals(3, newHash.size());
        newHash.put(50003, 50003);
        assertEquals(4, newHash.size());
        assertFalse(newHash.isEmpty());
    }

    @Test
    void deleteTest(){
        MyHash<String, String> NewHash1 = new MyClosedHashImpl<>();
        NewHash1.put("alpha", "one");
        NewHash1.put("beta", "two");
        NewHash1.put("delta", "four");
        NewHash1.put("epsilon", "five");
        NewHash1.put("zeta", "six");
        assertEquals(5, NewHash1.size());
        assertFalse(NewHash1.isEmpty());
        NewHash1.delete("alpha");
        assertEquals(4, NewHash1.size());
        NewHash1.delete("beta");
        assertEquals(3, NewHash1.size());
    }

    @Test
    void getTest(){
        MyHash<String, String> NewHash2 = new MyClosedHashImpl<>();
        NewHash2.put("alpha", "one");
        NewHash2.put("beta", "two");
        NewHash2.put("gamma", "three");
        NewHash2.put("zeta", "six");
        assertEquals(4, NewHash2.size());
        assertEquals("one", NewHash2.get("alpha"));
        assertEquals("six", NewHash2.get("zeta"));
        NewHash2.delete("zeta");
        assertEquals(null, NewHash2.get("zeta"));
        assertEquals("three", NewHash2.get("gamma"));
        NewHash2.delete("gamma");
        assertEquals(null, NewHash2.get("gamma"));
    }

}