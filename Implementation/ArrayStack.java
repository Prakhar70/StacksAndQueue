package Implementation;
class ArrayStack {
    int top;
    int[] arr;
    int capacity;

    public ArrayStack(int capacity) {
        this.top = -1;
        this.arr = new int[capacity];
        this.capacity = capacity;
    }
    public ArrayStack() {
        this(1000);
    }

    public void push(int x) {
        if(top == capacity - 1){
            System.out.println("Overflow");
            return;
        }
        this.arr[++this.top]=x;
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        int rEle = this.arr[this.top];
        this.top--;
        return rEle;
    }

    public int top() {
        return this.arr[this.top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
