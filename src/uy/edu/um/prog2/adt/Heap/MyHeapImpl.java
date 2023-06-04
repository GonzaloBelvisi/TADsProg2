package uy.edu.um.prog2.adt.Heap;

public class MyHeapImpl <T extends Comparable<T>> implements MyHeap<T> {


    private T[] value;
    private int heapSize;

    public MyHeapImpl(int size) {
        this.value = (T[]) new Comparable[size];
        this.heapSize = 0;
    }

    private int getFatherPosition(int position) {
        return(position - 1) / 2;
    }

    private int getLeftChildPosition(int position){
        return 2 * position + 1;
    }

    private int getRightChildPosition(int position){
        return 2 * position + 2;
    }

    @Override
    public void insert(T newValue) {
        int position = heapSize;
        heapSize++;
        value[position] = newValue;
        while(value[position].compareTo(value[getFatherPosition(position)])>0 && position !=0){
            value[position] = value[getFatherPosition(position)];
            value[getFatherPosition(position)] = newValue;
            position = getFatherPosition(position);
        }

    }

    @Override
    public T delete() throws EmptyHeapException {
        T returnValue = null;
        if (heapSize == 0){
            throw new EmptyHeapException();
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
