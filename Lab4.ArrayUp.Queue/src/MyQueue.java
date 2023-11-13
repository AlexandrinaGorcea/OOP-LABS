class MyQueue implements Queue {
    private int[] queue;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    @Override
    public void enqueue(int value) {
        if (rear == queue.length - 1) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear++;
        }

        queue[rear] = value;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1; // Return a sentinel value to indicate error
        }

        int value = queue[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }

        return value;
    }

    @Override
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Return a sentinel value to indicate error
        }

        return queue[front];
    }
}
