package FAQs;

import java.util.HashMap;

public class LRUCache {
    class HMNode{
        int key;
        int val;
        HMNode(int key , int val){
            this.key = key;
            this.val = val;
        }
    }
    class ListNode{
        HMNode data;
        ListNode prev;
        ListNode next;
        ListNode(HMNode data){
            this.data = data;
            this.prev=null;
            this.next = null;
        }
    }
    class List{
        ListNode head;
        ListNode tail;
        int size;
        List(){
            this.tail = null;
            this.head = null;
            this.size = 0;
        }
        public ListNode removeNode(ListNode node){
            if(head == null && tail == null){//No node
                return null;
            }
            
            ListNode currNode = node;
            ListNode prevNode =node.prev;
            ListNode nextNode = node.next;
            if(prevNode != null){
                prevNode.next = nextNode;
            }
            if(nextNode != null){
                nextNode.prev = prevNode;
            }
    
            currNode.next = null;
            currNode.prev = null;
    
            if(prevNode == null){
                head = nextNode;
            }
            if(nextNode == null){
                tail = prevNode;
            }
            this.size--;
            return currNode;
        }
        public void addFirst(ListNode node){
            if(head == null && tail == null){
                head = node;
                tail = node;
                this.size++;
                return;
            }
            node.next = head;
            head.prev=node;
            head = node;
            this.size++;
    
        }
        public ListNode removeLast(){
            if(head == null  && tail == null){
                return null;
            }
            if(head == tail){
                ListNode rNode = tail;
                head = null;
                tail = null;
                return rNode;
            }
            ListNode rNode = tail;
            tail = tail.prev;
            rNode.prev = null;
            if(tail != null)
                tail.next = null;
            this.size--;
            return rNode;
        } 
    }
    HashMap<Integer, ListNode> hm;
    int capacity;
    List list;

    public LRUCache(int capacity) {
       this.hm = new HashMap<>();
       this.capacity = capacity;
       list = new List();
    }

    public int get(int key) {
       if(!hm.containsKey(key)){
        return -1;
       }
       ListNode rNode = list.removeNode(hm.get(key));
       list.addFirst(rNode);
       return rNode.data.val;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.get(key).data.val = value;
            ListNode rNode = list.removeNode(hm.get(key));
            list.addFirst(rNode);
            return;
        }
        ListNode node = new ListNode (new HMNode(key, value));
        if(list.size<=capacity-1){
            list.addFirst(node);
            hm.put(key, node);
        }else{
            ListNode rNode = list.removeLast();
            hm.remove(rNode.data.key);
            list.addFirst(node);
            hm.put(key, node);
        }
      
    }
}
