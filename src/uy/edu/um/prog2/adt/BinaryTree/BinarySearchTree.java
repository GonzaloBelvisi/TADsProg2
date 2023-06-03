package uy.edu.um.prog2.adt.BinaryTree;

public class BinarySearchTree<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T> {

    private int treeSize = 0;
    private NodeBST<K, T> root;
    public NodeBST<K, T> getRoot() {
        return root;
    }
    public void setRoot(NodeBST<K, T> root) {
        this.root = root;
    }

    // testeo municipio
    @Override
    public T find(K key) {
        return null;
    }

    @Override
    public void insert(K key, T data) {

    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return 0;
    }
}
