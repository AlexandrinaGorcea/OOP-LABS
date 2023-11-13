public class Main {
    public static void main(String[] args) {
        Stack stack = new MyStack();

        stack.push(24);
        stack.push(34);
        stack.push(44);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop()); // This will print an error message

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
