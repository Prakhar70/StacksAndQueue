package FAQs;
 import java.util.Stack;
 
class MinStack {

    Stack<Integer> st;
    int mini;
    public MinStack() {
        st = new Stack<>();
        mini = 0;
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            mini = val;
            return;
        }
        if(val<mini){
            st.push(2*val - mini);
            mini = val;
            return;
        }
        st.push(val);
    }

    public void pop() {
        if(st.isEmpty()){
            return ;
        }
        int x = st.pop();
        if(x<mini){
             mini = 2*mini - x;
        }

    }

    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        int x= st.peek();
        if(x<mini){
            return mini;
        }
        return x;
    }

    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }
        return mini;
    }
}