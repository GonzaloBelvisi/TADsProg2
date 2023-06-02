package uy.edu.um.prog2.adt.Hash;
import uy.edu.um.prog2.adt.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.ArrayList.MyArrayListImpl;

public class MyClosedHashImpl <K, V> implements MyHash<K, V> {

    private int tableSize;
    private int currentSize;
    private int occupiedSize;

    //ArrayList
    private MyArrayList<K> KeyList;

    private ClosedHashNode[] tableHash;
    private static final int DEFAULT_INITIAL_TABLE_HASH_SIZE = 100000;
    public void setTableHash(ClosedHashNode[] tableHash) {
        this.tableHash = tableHash;
    }
    public void setOccupiedSize(int occupiedSize) {
        this.occupiedSize = occupiedSize;
    }
    public void setKeyList(MyArrayList<K> KeyList) {
        this.KeyList = KeyList;
    }
    private void initVector(){
        for (int i = 0; i< tableSize; i++){
            tableHash[i] = null;
        }
        currentSize = 0;
    }
    public MyClosedHashImpl(int maxExpectedSize){
        tableHash = new ClosedHashNode[maxExpectedSize];
        tableSize = maxExpectedSize;
        this.KeyList = new MyArrayListImpl<>(maxExpectedSize);
        initVector();
    }
    public MyClosedHashImpl(){
        tableHash = new ClosedHashNode[DEFAULT_INITIAL_TABLE_HASH_SIZE];
        tableSize = DEFAULT_INITIAL_TABLE_HASH_SIZE;
        this.KeyList = new MyArrayListImpl<>(100000);
        initVector();
    }



    @Override
    public void put(K key, V value) {
        if ((float) occupiedSize / tableSize >= 0.7){
        }

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public K KeyListKeys(int spot) {
        return null;
    }
}
