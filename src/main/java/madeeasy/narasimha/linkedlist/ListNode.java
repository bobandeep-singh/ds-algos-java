package madeeasy.narasimha.linkedlist;

public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
