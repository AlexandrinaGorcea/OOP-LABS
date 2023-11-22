package Stack;

public class DoubleLinkedlistStack implements Stack {
    private DoubleNode top;

    @Override
    public void push(int value) {
        Node newNode = new DoubleNode(value);
        if (top != null) {
            newNode.next = top;
            top.prev = newNode;
        }
        top = newNode;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // Return a sentinel value to indicate error
        }

        int value = top.data;
        top = top.next;

        if (top != null) {
            top.prev = null;
        }

        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Return a sentinel value to indicate error
        }
        return top.data;
    }

}
