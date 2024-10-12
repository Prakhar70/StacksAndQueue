import java.util.Stack;

class QueueUsingStack1 {
    
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    public QueueUsingStack1() {
        st1 = new Stack<>();//push stack
        st2 = new Stack<>();//pop stack
    }
    
    public void push(int x) {
        st1.push(x);//0(1)
    }
    
    public int pop() {
        if(st2.isEmpty()){
            if(st1.isEmpty()){
                return -1;
            }
            //Transfer all the element from st1 to st2;
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty()){
            if(st1.isEmpty()){
                return -1;
            }
            //Transfer all the element from st1 to st2;
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
