public class VectorHeap<E extends Comparable<E>> {
    private E[] data;
    private int size;

    public VectorHeap() {
        data = (E[]) new Comparable[10];
        size = 0;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void percolateUp(int i) {
        E value = data[i];
        while (i > 0 && value.compareTo(data[parent(i)]) < 0) {
            data[i] = data[parent(i)];
            i = parent(i);
        }
        data[i] = value;
    }

    public void add(E value) {
        if (size >= data.length)
            reallocate();
        data[size] = value;
        size++;
        percolateUp(size - 1);
    }

    public void reallocate() {
        E[] newData = (E[]) new Comparable[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public void buildHeap() {
        for (int i = parent(size - 1); i >= 0; i--) {
            percolateDown(i);
        }
    }

    public void percolateDown(int i) {
        int child;
        E value = data[i];
        while (left(i) < size) {
            child = left(i);
            if (child + 1 < size && data[child + 1].compareTo(data[child]) < 0)
                child++;
            if (data[child].compareTo(value) < 0) {
                data[i] = data[child];
            } else {
                break;
            }
            i = child;
        }
        data[i] = value;
    }

    public E remove() {
        if (size == 0)
            return null;
        E minVal = data[0];
        data[0] = data[size - 1];
        size--;
        percolateDown(0);
        return minVal;
    }

    public int size() {
        return size;
    }
}