package Queue;

public interface Queue {
    void enqueue(int value);
    int dequeue();
    boolean isEmpty();
    int peek();

}
