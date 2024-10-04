public class Fila<T> {
    private T[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Fila(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void add(T value) {
        if (size == capacity) {
            expandCapacity();
        }
        rear = (rear + 1) % capacity;
        elements[rear] = value;
        size++;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T value = elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void expandCapacity() {
        int newCapacity = capacity * 2;
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = elements[(front + i) % capacity];
        }

        elements = newArray;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }
}
