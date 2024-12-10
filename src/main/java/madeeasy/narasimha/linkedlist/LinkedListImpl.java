package madeeasy.narasimha.linkedlist;

public class LinkedListImpl {
    private int length;
    ListNode head;
    public LinkedListImpl(){
        this.length = 0;
    }

    public synchronized ListNode getHead(){
        return this.head;
    }

    public synchronized void insertAtBegin(ListNode node){
        if(null == this.head){
            this.head = node;
        } else{
            node.next = this.head;
            this.head = node;
        }
        this.length++;
    }

    public synchronized void insertAtEnd(ListNode node){
        if(null == this.head){
            this.head = node;
        } else{
            ListNode temp = this.head.next;
            while(temp != null){
                temp = temp.next;
            }
            temp.next = node;
            node.next = null;
        }
        this.length++;
    }

    public synchronized void insert(ListNode node, int position){
        ListNode prevNode = null;
        ListNode tempHead = this.head;
       for(int i = 0; i < position-1; i++){
           prevNode = tempHead;
           tempHead = tempHead.next;
       }
       prevNode.next = node;
       node.next = tempHead;
       this.length++;
    }

    public synchronized void removeFromBegin(){
        if(this.length == 0){
            return;
        }

        this.head = this.head.next;
        this.length--;
    }


    public synchronized void removeFromEnd(){
        if(this.length == 0){
            return;
        }
        ListNode tempHead = this.head.next;
        ListNode previousNode = this.head;
        while(tempHead != null){
            previousNode = tempHead;
            tempHead = tempHead.next;
        }
        previousNode.next = null;
        this.length--;
    }

    public synchronized void removeMatched(int data){
        if(this.length == 0){
            return;
        }
        ListNode tempHead = this.head;
        ListNode previousNode = tempHead;
        while(tempHead != null){
            if(tempHead.data == data){
                previousNode.next = tempHead.next;
                tempHead.next = null;
                break;
            }
            tempHead = tempHead.next;
        }
        this.length--;
    }

    public synchronized void remove(int position){
        if(this.length == 0){
            return;
        }
        ListNode tempHead = this.head;
        ListNode previousNode = tempHead;
        for(int i = 0; i < position; i++){
            previousNode = tempHead;
            tempHead = tempHead.next;
        }

        previousNode.next = tempHead.next;
        tempHead.next = null;
    }

    public int getLength(){
        return this.length;
    }

    public int getPosition(int data){
        ListNode tempHead = this.head;
        int i = 0;
        boolean found = false;
        while(null != tempHead){
            if(tempHead.data == data){
                found = true;
                break;
            }
            i++;
        }
        return found ? i : -1;
    }

    public synchronized void clearList(){
        this.length = 0;
        this.head = null;
    }
}
