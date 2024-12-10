package madeeasy.narasimha.linkedlist;

public class TraversingLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        printLinkedList(node1);
        printLinkedList(node3);

        System.out.println(getLinkedListLength(node1));
        System.out.println(getLinkedListLength(node3));

    }

    public static void printLinkedList(ListNode llist){
        ListNode currentNode = llist;
        while(currentNode != null){
            System.out.print(currentNode.getData() + " - ");
            currentNode = currentNode.getNext();
        }
        System.out.println("null");
    }


    public static int getLinkedListLength(ListNode listNode){
        int length = 0;
        ListNode currentNode = listNode;
        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }
}
