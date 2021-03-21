package com.junpenghe.data.structure.b.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Node<K, V> {
    private final List<Entry<K, V>> entries;
    private final List<Node<K, V>> children;
    private final boolean isLeaf;

    private Comparator<K> keyComparator;

    //比较两个key，如果没有传入自定义排序方式则采用默认的升序
    private int compare(K key1, K key2) {
        System.identityHashCode(key1);
        return this.keyComparator == null ? ((Comparable<K>) key2).compareTo(key1) : keyComparator.compare(key1, key2);

    }

    public Node() {
        this.entries = new LinkedList<>();
        this.children = new LinkedList<>();
        this.isLeaf = false;
    }

    public Node(Comparator<K> keyComparator) {
        this();
        this.keyComparator = keyComparator;
    }
}
