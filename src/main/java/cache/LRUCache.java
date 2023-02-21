package cache;

import java.util.HashMap;

public class LRUCache<T>{
    private final int capacity;
    private final HashMap<String, Node> hashmap;
    private final DoublyLinkedList queue;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashmap = new HashMap<>();
        this.queue = new DoublyLinkedList();
    }

    public T get(String key){
        if(null == key || !hashmap.containsKey(key)){
            return null;
        }
        return hashmap.get(key).value;
    }

    public void put(String key, T value){
        if(null == key) return;

        // check if the key already exist in HM
        Node presentNode = hashmap.get(key);
        if(null != presentNode){
            presentNode.value = value;

            queue.moveNodeToFront(presentNode);
            return;
        }

        // check if queue is full
        if(size == capacity){
            String rearNodeKey = queue.getRearNodeKey();
            queue.removeNodeFromRear();
            hashmap.remove(rearNodeKey);
            size--;
        }

        // create a new node
        Node newNode = new Node(key, value);
        queue.addNodeToFront(newNode);
        hashmap.put(key, newNode);
        size++;
    }
    private class DoublyLinkedList{
        private Node front, rear;
        public DoublyLinkedList() {
            this.front = null;
            this.rear = null;
        }

        public void moveNodeToFront(Node node) {
            if(front == rear){
                front = rear = node;
            }
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = front;
            front = node;
        }

        public void removeNodeFromRear() {
            rear.prev.next = null;
        }

        public void addNodeToFront(Node node) {
            if(front == null){
                front = node;
            } else{
                node.next = front;
                node.prev = null;
                front = node;
            }
        }

        public String getRearNodeKey() {
            if(rear == null){
                return null;
            } else{
                return rear.key;
            }
        }
    }

    private class Node{
        private String key;
        private T value;
        Node prev, next;

        public Node(String key, T value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

}

/*
HM - String, Node

Node:
    String key
    T value
    Node prev, next

Queue - DLL:
    Node front, rear;
 */