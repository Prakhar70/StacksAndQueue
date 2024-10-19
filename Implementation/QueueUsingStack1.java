package Implementation;
import java.util.Stack;

class QueueUsingStack1 {
    
    private Stack<Integer> pushSt;
    private Stack<Integer> popSt;
    public QueueUsingStack1() {
        pushSt = new Stack<>();//push stack
        popSt = new Stack<>();//pop stack
    }
    
    public void push(int x) {
        pushSt.push(x);//0(1)
    }
    
    public int pop() {//0(1)
        if(popSt.isEmpty()){
            if(pushSt.isEmpty()){
                return -1;
            }
            //Transfer all the element from pushSt to popSt;
            while(!pushSt.isEmpty()){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.pop();
    }
    
    public int peek() {//O(1)
        if(popSt.isEmpty()){
            if(pushSt.isEmpty()){
                return -1;
            }
            //Transfer all the element from pushSt to popSt;
            while(!pushSt.isEmpty()){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.peek();
    }
    
    public boolean isEmpty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }
}
