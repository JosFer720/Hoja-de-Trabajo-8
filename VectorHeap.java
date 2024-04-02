/**
 * Fernando Ruiz
 * 23065
 * 
 * Implementación de una cola de prioridad basada en un heap vectorial.
 * @param <E> El tipo de elementos que contendrá la cola de prioridad.
 */
public class VectorHeap<E extends Comparable<E>> {
    private E[] data;
    private int size;

    /**
     * Crea una nueva cola de prioridad basada en un heap vectorial con una capacidad inicial de 10.
     */
    public VectorHeap() {
        data = (E[]) new Comparable[10];
        size = 0;
    }

    /**
     * Calcula el índice del padre de un nodo dado.
     * @param i El índice del nodo hijo.
     * @return El índice del nodo padre.
     */
    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Calcula el índice del hijo izquierdo de un nodo dado.
     * @param i El índice del nodo padre.
     * @return El índice del hijo izquierdo.
     */
    public int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Calcula el índice del hijo derecho de un nodo dado.
     * @param i El índice del nodo padre.
     * @return El índice del hijo derecho.
     */
    public int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Mueve hacia arriba un elemento en el heap para mantener la propiedad del heap.
     * @param i El índice del elemento a percolar hacia arriba.
     */
    public void percolateUp(int i) {
        E value = data[i];
        while (i > 0 && value.compareTo(data[parent(i)]) < 0) {
            data[i] = data[parent(i)];
            i = parent(i);
        }
        data[i] = value;
    }

    /**
     * Agrega un elemento a la cola de prioridad.
     * @param value El elemento a agregar.
     */
    public void add(E value) {
        if (size >= data.length)
            reallocate();
        data[size] = value;
        size++;
        percolateUp(size - 1);
    }

    /**
     * Reasigna la capacidad del heap vectorial cuando se llena.
     */
    public void reallocate() {
        E[] newData = (E[]) new Comparable[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    /**
     * Construye un heap a partir de los elementos actuales en la cola de prioridad.
     */
    public void buildHeap() {
        for (int i = parent(size - 1); i >= 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * Mueve hacia abajo un elemento en el heap para mantener la propiedad del heap.
     * @param i El índice del elemento a percolar hacia abajo.
     */
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

    /**
     * Elimina y devuelve el elemento de mayor prioridad de la cola de prioridad.
     * @return El elemento de mayor prioridad, o null si la cola de prioridad está vacía.
     */
    public E remove() {
        if (size == 0)
            return null;
        E minVal = data[0];
        data[0] = data[size - 1];
        size--;
        percolateDown(0);
        return minVal;
    }

    /**
     * Obtiene el número de elementos en la cola de prioridad.
     * @return El número de elementos en la cola de prioridad.
     */
    public int size() {
        return size;
    }
}