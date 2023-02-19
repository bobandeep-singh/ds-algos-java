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

        return null;
    }

    public void put(String key, T value){

    }

    private class DoublyLinkedList{
        private Node front, prev;
        public DoublyLinkedList() {
            this.front = null;
            this.prev = null;
        }
    }

    private class Node{
        private String key;
        private T value;
        private Node prev, next;
        private Node(String key, T value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
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