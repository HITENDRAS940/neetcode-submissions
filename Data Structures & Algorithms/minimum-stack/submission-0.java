class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int value) {
        st.push(value);

        if (minSt.isEmpty() || value <= minSt.peek()) {
            minSt.push(value);
        }
    }

    public void pop() {
        int x = st.pop();

        if (!minSt.isEmpty() && x == minSt.peek()) {
            minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}