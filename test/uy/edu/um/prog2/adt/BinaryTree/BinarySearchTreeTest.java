package uy.edu.um.prog2.adt.BinaryTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.prog2.adt.LinkedList.MyLinkedListImpl;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer, String> bst;

    @Before
    public void setup() {
        bst = new BinarySearchTree<>();
        bst.insert(8, "Ocho");
        bst.insert(3, "Tres");
        bst.insert(10, "Diez");
        bst.insert(1, "Uno");
        bst.insert(6, "Seis");
        bst.insert(14, "Catorce");
        bst.insert(4, "Cuatro");
        bst.insert(7, "Siete");
        bst.insert(13, "Trece");
    }

    @Test
    public void testFind() {
        Assert.assertEquals("Cuatro", bst.find(4));
        Assert.assertEquals("Trece", bst.find(13));


        Assert.assertNull(bst.find(5));
    }

    @Test
    public void testDelete() {

        bst.delete(6);
        bst.delete(14);
        bst.delete(3);


        Assert.assertNull(bst.find(6));
        Assert.assertNull(bst.find(14));
        Assert.assertNull(bst.find(3));


        Assert.assertEquals(6, bst.size());
    }

    @Test
    public void testInOrderTraversal() {
        MyLinkedListImpl<NodeBST<Integer, String>> inOrderList = bst.inOrder();

        Assert.assertEquals("Uno", inOrderList.get(0).getData());
        Assert.assertEquals("Tres", inOrderList.get(1).getData());
        Assert.assertEquals("Cuatro", inOrderList.get(2).getData());
        Assert.assertEquals("Seis", inOrderList.get(3).getData());
        Assert.assertEquals("Siete", inOrderList.get(4).getData());
        Assert.assertEquals("Ocho", inOrderList.get(5).getData());
        Assert.assertEquals("Diez", inOrderList.get(6).getData());
        Assert.assertEquals("Trece", inOrderList.get(7).getData());
        Assert.assertEquals("Catorce", inOrderList.get(8).getData());
    }

    @Test
    public void testPreOrderTraversal() {
        MyLinkedListImpl<NodeBST<Integer, String>> preOrderList = bst.preOrder();

        Assert.assertEquals("Ocho", preOrderList.get(0).getData());
        Assert.assertEquals("Tres", preOrderList.get(1).getData());
        Assert.assertEquals("Uno", preOrderList.get(2).getData());
        Assert.assertEquals("Seis", preOrderList.get(3).getData());
        Assert.assertEquals("Cuatro", preOrderList.get(4).getData());
        Assert.assertEquals("Siete", preOrderList.get(5).getData());
        Assert.assertEquals("Diez", preOrderList.get(6).getData());
        Assert.assertEquals("Catorce", preOrderList.get(7).getData());
        Assert.assertEquals("Trece", preOrderList.get(8).getData());
    }

    @Test
    public void testPostOrderTraversal() {
        MyLinkedListImpl<NodeBST<Integer, String>> postOrderList = bst.postOrder();

        Assert.assertEquals("Uno", postOrderList.get(0).getData());
        Assert.assertEquals("Cuatro", postOrderList.get(1).getData());
        Assert.assertEquals("Siete", postOrderList.get(2).getData());
        Assert.assertEquals("Seis", postOrderList.get(3).getData());
        Assert.assertEquals("Tres", postOrderList.get(4).getData());
        Assert.assertEquals("Trece", postOrderList.get(5).getData());
        Assert.assertEquals("Catorce", postOrderList.get(6).getData());
        Assert.assertEquals("Diez", postOrderList.get(7).getData());
        Assert.assertEquals("Ocho", postOrderList.get(8).getData());
    }
}
