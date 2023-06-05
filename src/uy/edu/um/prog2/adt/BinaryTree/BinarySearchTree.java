package uy.edu.um.prog2.adt.BinaryTree;


import uy.edu.um.prog2.adt.LinkedList.MyLinkedListImpl;


public class BinarySearchTree<K extends Comparable<K>, T> implements MyBinarySearchTree<K,T> {
    // Comparable <K> porque para el ordenamiento de un BST es necesario la comparacion de
    // mayor menor o igual entre las Keys
    private int treeSize = 0;
    private NodeBST<K, T> root;
    public NodeBST<K, T> getRoot() {
        return root;
    }
    public void setRoot(NodeBST<K, T> root) {
        this.root = root;
    }
    


    // Creamos un metodo de busqueda que en primer lugar consiga el nodo correspondiente a la key
    private NodeBST<K, T> find(K key, NodeBST<K, T> root) throws NotInTreeException {

        NodeBST<K, T> result = null;

        //Caso base para la recursividad
        if (root != null) {
            if (key.compareTo(root.getKey()) == 0) {
                result = root;
            }
        // Caso recursivo
            else if (key.compareTo(root.getKey()) < 0) {
                result = find(key, root.getLeftChild());
            } else {
                result = find(key, root.getRightChild());
            }
        }
        if (result == null) {
            throw new NotInTreeException();
        }
        return result;
    }
    @Override
    public T find(K key) {
        //Realizamos un bloque try catch para que maneje el error de busqueda
        try {
            return find(key, root).getData(); //Obtenemos el valor vinculado a la key que buscamos
        } catch (NotInTreeException e) {
            return null;
        }
    }

    @Override
    public void insert(K key, T data) {   root = insert(key, data, root);
        treeSize ++;
    }

    private NodeBST<K, T> insert(K key, T data, NodeBST<K, T> subtree) {
    //Creamos un nuevo nodo con la key y data entregada
        NodeBST<K, T> NewElement = new NodeBST<K, T>(key, data);
    // Caso base
        if (subtree == null) {
            return NewElement;
    // Caso recursivo
        } else {
    // La key a insertar es menor que la key de la raiz (subtree)
            if (subtree.getKey().compareTo(key) > 0) {
                NodeBST<K, T> newLeft = insert(key, data, subtree.getLeftChild());
                subtree.setLeftChild(newLeft);
                return subtree;
    //La key a insertar es mayor que la key de la raiz (sub tree)
            } else if (subtree.getKey().compareTo(key) < 0) {
                NodeBST<K, T> newRight = insert(key, data, subtree.getRightChild());
                subtree.setRightChild(newRight);
                return subtree;
            }
        }
        return null;
    }

    @Override
    public void delete(K key){
        try {
            root = delete(key, root);
            treeSize--;
        } catch (NotInTreeException e) {
            System.out.println("Not in tree.");
        }
    }

    public NodeBST<K, T> delete(K key, NodeBST<K, T> subtree) throws NotInTreeException {

        //Chequeamos que el subtree no sea nulo
        if (subtree == null) {
            return null;
        }
        // Buscamos que el nodo a eleminar exista en el arbol
        if (this.find(key) == null) {
            throw new NotInTreeException();
        }

        if (key.compareTo(subtree.getKey()) == 0) { //encontre el nodo a eliminar
            if (subtree.getLeftChild() == null && subtree.getRightChild() == null) { // no queda ningún hijo
                return null;
            }
            if (subtree.getLeftChild() == null) { //solo queda hijo derecho
                return subtree.getRightChild();
            }
            if (subtree.getRightChild() == null) { //solo queda hijo izquierdo
                return subtree.getLeftChild();
            }
            //cuando tengo dos hijos, busco el menor valor del lado derecho.
            K minKey = minKey(subtree.getRightChild());
            subtree.setData(find(minKey));
            subtree.setKey(minKey);
            subtree.setRightChild(delete(minKey, subtree.getRightChild()));
            return subtree;
        } else if (key.compareTo(subtree.getKey()) < 0) {
            subtree.setLeftChild(delete(key, subtree.getLeftChild()));
        } else {
            subtree.setRightChild(delete(key, subtree.getRightChild()));
        }
        return subtree;

    }

    private K minKey(NodeBST<K, T> node) {

    //Chequeamos que el arbol no este vacio

        if (node == null) {
            return null;
        }
    // Recursivamente llamamos a la funcion hasta llegar al elemento mas chico el cual no tiene hijos a su izquierda.

        if (node.getLeftChild() != null) {
            return minKey(node.getLeftChild());
        }
        return node.getKey();
    }


    @Override
    public int size() {
        return treeSize;
    }

    public MyLinkedListImpl<NodeBST<K, T>> inOrder() {
        MyLinkedListImpl<NodeBST<K, T>> list = new MyLinkedListImpl<>();
        inOrderHelper(root, list);
        return list;
    }

    private void inOrderHelper(NodeBST<K, T> node, MyLinkedListImpl<NodeBST<K, T>> list) {
    // Chequeamos si el nodo es nulo
        if (node != null) {
            //Si no es nulo reecursivamente nos movemos hasta la izquierda hasta el mas chico
            inOrderHelper(node.getLeftChild(), list);
            // Una vez llegamos al que esta mas a la izquierda agregamos ese nodo a la lista
            list.add(node);
            //Nos movemos uno hacia la derecha
            inOrderHelper(node.getRightChild(), list);
            // Se repite recursivamente el proceso
        }
    }

    public MyLinkedListImpl<NodeBST<K, T>> preOrder() {
        MyLinkedListImpl<NodeBST<K, T>> list = new MyLinkedListImpl<>();
        preOrderHelper(root, list);
        return list;
    }

    private void preOrderHelper(NodeBST<K, T> node, MyLinkedListImpl<NodeBST<K, T>> list) {
        if (node != null) {
            list.add(node);
            preOrderHelper(node.getLeftChild(), list);
            preOrderHelper(node.getRightChild(), list);
        }
    }

    public MyLinkedListImpl<NodeBST<K, T>> postOrder() {
        MyLinkedListImpl<NodeBST<K, T>> list = new MyLinkedListImpl<>();
        postOrderHelper(root, list);
        return list;
    }

    private void postOrderHelper(NodeBST<K, T> node, MyLinkedListImpl<NodeBST<K, T>> list) {
        if (node != null) {
            postOrderHelper(node.getLeftChild(), list);
            postOrderHelper(node.getRightChild(), list);
            list.add(node);
        }
    }

}


