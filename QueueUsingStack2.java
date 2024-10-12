import java.util.Stack;

class QueueUsingStack2 {
    
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    public QueueUsingStack2() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        st1.push(x);
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }
    
    public int pop() {
        if (st1.isEmpty()) {
            return -1;
        }
        return st1.pop();
    }
    
    public int peek() {
        if (st1.isEmpty()) {
            return -1;
        }
        return st1.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}