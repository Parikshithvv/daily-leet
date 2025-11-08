class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue and returns that element
    public int pop() {
        // Move elements to output stack if it's empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    // Get the front element
    public int peek() {
        // Move elements to output stack if it's empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

