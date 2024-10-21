package Implementation;

class LinkedListQueue {
    ListNode front;
    ListNode rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    public void push(int x) {
        ListNode newNode = new ListNode(x);
        if (isEmpty()) {
            rear = newNode;
            front = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }


    public int pop() {
        if (isEmpty()) {
            System.out.println("Overflow");
            return -1;
        }
        int rVal = front.data;
        front = front.next;
        return rVal;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Overflow");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
