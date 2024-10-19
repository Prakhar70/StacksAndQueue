package Implementation;

class ArrayQueue {
    int front;
    int rear;
    int[] arr;
    int capacity;

    public ArrayQueue(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
    }

    public ArrayQueue() {
        this(10000);
    }

    public void push(int x) {
        if (rear == capacity - 1) {
            System.out.println("Overflow");
            return;
        }
        if (front == rear && front == -1) {
            front++;
        }
        arr[++rear] = x;
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Undeflow");
            return -1;
        }
        int poppedElement = this.arr[front++];
        return poppedElement;

    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Undeflow");
            return -1;
        }
        return this.arr[front];
    }

    public boolean isEmpty() {
        return ((front == rear && rear == -1) || (front > rear));
    }
}
