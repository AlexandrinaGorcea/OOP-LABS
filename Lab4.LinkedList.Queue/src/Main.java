public class Main {
    public static void main(String[] args) {
        Queue queue = new MyQueue();

        queue.enqueue(24);
        queue.enqueue(34);
        queue.enqueue(44);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue()); // This will print an error message

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
