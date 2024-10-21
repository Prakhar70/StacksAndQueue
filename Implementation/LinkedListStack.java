package Implementation;

class LinkedListStack {
    ListNode head;
    public LinkedListStack() {
        head = null;
    }

    public void push(int x) {
        ListNode newNode = new ListNode(x);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if(head == null){
            System.out.println("Underflow");
            return -1;
        }
        int topElement = head.data;
        head = head.next;
        return topElement;
    }

    public int top() {
        if(head == null){
            System.out.println("Underflow");
            return -1;
        }
        int topElement = head.data;
        return topElement;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
