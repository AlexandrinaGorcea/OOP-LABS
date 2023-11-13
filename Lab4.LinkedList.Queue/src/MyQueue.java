class MyQueue implements Queue {
    private Node front;
    private Node rear;

    @Override
    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1; // Return a sentinel value to indicate error
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null; // Update rear if queue is now empty
        }

        return value;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Return a sentinel value to indicate error
        }
        return front.data;
    }
}
