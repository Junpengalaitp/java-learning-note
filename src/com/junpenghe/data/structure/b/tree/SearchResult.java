package com.junpenghe.data.structure.b.tree;

public class SearchResult<V> {
    private boolean exists;
    private V value;
    private int index;

    public SearchResult(boolean exists, V value, int index) {
        this.exists = exists;
        this.value = value;
        this.index = index;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
