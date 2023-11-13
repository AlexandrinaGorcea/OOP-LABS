class MyStack implements Stack {
    private int[] stack;
    private int free;

    public MyStack(int capacity) {
        stack = new int[capacity];
        free = capacity - 1;
    }

    @Override
    public void push(int value) {
        if (free < 0) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stack[free] = value;
        free--;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // Return a sentinel value to indicate error
        }
        int value = stack[free + 1];
        free++;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return free == stack.length - 1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Return a sentinel value to indicate error
        }
        return stack[free + 1];
    }
}
