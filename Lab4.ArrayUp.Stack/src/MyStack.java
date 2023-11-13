class MyStack implements Stack {
    private int[] stack;
    private int count;

    public MyStack(int capacity) {
        stack = new int[capacity];
        count = -1;
    }

    @Override
    public void push(int value) {
        if (count == stack.length - 1) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        count++;
        stack[count] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // Return a sentinel value to indicate error
        }
        int value = stack[count];
        count--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return count == -1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Return a sentinel value to indicate error
        }
        return stack[count];
    }
}
