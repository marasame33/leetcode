package leetcode;

import java.util.concurrent.ConcurrentHashMap;

public class LruCache<V> {

    public ConcurrentHashMap<String, ListNode<String, V>> cache = new ConcurrentHashMap<>();

    private Integer capacity;

    private ListNode<String, V> head;

    private ListNode<String, V> tail;

    private Integer count;

    public static class ListNode<K, V> {

        private K key;

        private V value;

        private ListNode<K, V> pre;

        private ListNode<K, V> post;

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {

        }
    }

    public LruCache(Integer capacity) {
        this.capacity = capacity;
        this.count = 0;

        this.head = new ListNode<>();
        this.tail = new ListNode<>();

        this.head.pre = null;
        this.tail.post = null;

        this.head.post = tail;

        this.tail.pre = head;
    }


    public V get(String key) {
        ListNode<String, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void set(String key, ListNode<String, V> value) {
        ListNode<String, V> node = cache.get(key);
        // 当node不在列表中时，则插入缓存
        if (node == null) {
            // 当缓存容量已到限定容量
            if (cache.size() == capacity) {
                // 1.先从table中移除最后一个元素
                cache.remove(tail.pre.key);
                tail.pre.post = tail.post;
                tail = tail.pre;
                tail.post = null;
            }
            // 2.插入HashMap
            cache.put(key, value);
            // 3.插入双向链表表头
            insertNode(value);
        }
        // 当缓存中存在node时，将node移到列表的头部
        moveToHead(cache.get(key));
    }

    private void moveToHead(ListNode<String, V> node) {
        // 1.首先将node从双向链表中移除
        node.pre.post = node.post;
        node.post.pre = node.pre;
        // 2.将node插入链表头
        insertNode(node);
    }

    private void insertNode(ListNode<String, V> node) {
        head.post.pre = node;
        node.post = head.post;
        head.post = node;
        node.pre = head;
    }

    public void printLinkNode() {
        ListNode<String, V> ptr = head;
        while (ptr.post != null) {
            System.out.print(ptr.value + " ");
            ptr = ptr.post;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LruCache<Integer> cache = new LruCache<>(3);
        ListNode<String, Integer> node1 = new ListNode<>("key1", 1);
        ListNode<String, Integer> node2 = new ListNode<>("key2", 2);
        ListNode<String, Integer> node3 = new ListNode<>("key3", 3);
        ListNode<String, Integer> node4 = new ListNode<>("key4", 4);
        ListNode<String, Integer> node5 = new ListNode<>("key5", 5);
        cache.set("key1", node1);
        cache.printLinkNode();
        cache.set("key2", node2);
        cache.printLinkNode();
        cache.set("key3", node3);
        cache.printLinkNode();
        cache.set("key4", node4);
        cache.printLinkNode();
        cache.get("key2");
        cache.printLinkNode();
        cache.set("key5", node5);
        cache.printLinkNode();
        cache.get("key2");
        cache.printLinkNode();

    }


}
