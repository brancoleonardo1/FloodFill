public class Pilha<T> {
    private T[] elements;
    private int top;
    private int capacity;

    public Pilha(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == capacity - 1) {
            expandCapacity();
        }
        elements[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return elements[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void expandCapacity() {
        int newCapacity = capacity * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, capacity);
        elements = newArray;
        capacity = newCapacity;
    }
}
