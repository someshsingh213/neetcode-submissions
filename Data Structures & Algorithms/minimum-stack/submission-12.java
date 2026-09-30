class Node {

int val;
Node next;
Node prev;
Node minSoFar;

Node(int val) {
    this.val = val;
    this.next = null;
    this.prev = null;
    this.minSoFar = null;
}

}

class MinStack {

    Node head;
    Node curr;
    
    public MinStack() {
        head = null;
        curr = head;
    }
    
    public void push(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            curr = head;
            newNode.minSoFar = curr;         
        } else {
            curr.next = newNode;
        Node tmp = curr;
        curr = curr.next;
        curr.prev = tmp;
        if(tmp.minSoFar.val > newNode.val){
            curr.minSoFar = newNode;
        } else {
            curr.minSoFar = tmp.minSoFar;
        }

        }
    }
    
    public void pop() {
        if(head == null){
            //do nothing
        } else {
            Node temp = curr;
            curr = curr.prev;
            if(curr == null) {
                head = null;
            } else {
                curr.next = null;
            }
            
            
        }
        
    }
    
    public int top() {
        return curr.val;
    }
    
    public int getMin() {
        //return minHeap.peek().val;
        return curr.minSoFar.val;
    }
}
